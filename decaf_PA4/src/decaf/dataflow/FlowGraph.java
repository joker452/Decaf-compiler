package decaf.dataflow;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;

import decaf.tac.Functy;
import decaf.tac.Tac;
import decaf.tac.Temp;
import decaf.tac.Tac.Kind;

/**
 * @author Deng
 * FlowGraph for each Functy
 */
public class FlowGraph implements Iterable<BasicBlock> {

    private Functy functy;

    private List<BasicBlock> bbs;

    private Pair debug = new Pair(269, new Temp(118, "_T", 4, Integer.MAX_VALUE));
    public FlowGraph(Functy func) {
        this.functy = func;
        deleteMemo(func);
        bbs = new ArrayList<BasicBlock>();
        // set the bbNum of each tac
        markBasicBlocks(func.head);
        // construct BasicBlocks and their relations, and add them to bbs
        gatherBasicBlocks(func.head);
        // remove unreachable basic blocks
        // note after this, bbNum of tacs doesn't change,
        // but it doesn't matter because the only usage of bbNum of
        // tacs is to set bbNum of basic blocks
        simplify();

        for (BasicBlock bb : bbs) {
            bb.allocateTacIds();
        }
        int i = 0;

        // liveness analysis at basic block level
        analyzeLiveness();
        resolveDUChain();
        for (BasicBlock bb : bbs) {
            // liveness analysis at Tac level
            bb.analyzeLiveness();
            bb.resolveDUChain();
        }
    }

    /**
     * remove Memo records. Memo is used only by TAC simulator
     */
    private void deleteMemo(Functy func) {
        while (func.head != null && func.head.opc == Tac.Kind.MEMO) {
            func.head = func.head.next;
        }
        for (Tac t = func.head; t != null; t = t.next) {
            if (t.opc == Tac.Kind.MEMO) {
                if (t.prev != null) {
                    t.prev.next = t.next;
                }
                if (t.next != null) {
                    t.next.prev = t.prev;
                }
            }
        }

    }

    private void markBasicBlocks(Tac t) {
        int index = -1;
        boolean atStart = false;

        for (; t != null; t = t.next) {
            t.bbNum = index;
            switch (t.opc) {
                case RETURN:
                case BRANCH:
                case BEQZ:
                case BNEZ:
                    index++;
                    atStart = true;
                    break;
                case MARK:
                    if (!t.label.target) {
                        // delete labels that are not targets
                        if (t.prev != null) {
                            t.prev.next = t.next;
                        } else {
                            functy.head = t.next;
                        }
                        if (t.next != null) {
                            t.next.prev = t.prev;
                        }
                    } else {
                        // if the instruction before the label isn't jump
                        // this is because jump already start a new block
                        if (!atStart) {
                            index++;
                            t.bbNum = index;
                            atStart = true;
                        }
                    }
                    break;
                default:
                    atStart = false;
                    break;
            }
        }

    }

    private void gatherBasicBlocks(Tac start) {
        BasicBlock current;
        Tac nextStart;
        Tac end;
        // the bbNum of the first block is always 0
        while (start != null && start.bbNum < 0) {
            start = start.next;
        }

        for (; start != null; start = nextStart) {
            int bbNum = start.bbNum;
            // basic blocks don't contain Mark
            while (start != null && start.opc == Tac.Kind.MARK) {
                start = start.next;
            }
            // Functy corresponds to an empty block
            if (start == null) {
                current = new BasicBlock();
                current.bbNum = bbNum;
                current.tacList = null;
                current.endKind = BasicBlock.EndKind.BY_RETURN;
                current.next[0] = current.next[1] = -1;
                nextStart = null;
            } else {
                start.prev = null;
                end = start;
                while (end.next != null && end.next.bbNum == start.bbNum) {
                    end = end.next;
                }
                nextStart = end.next;
                current = new BasicBlock();
                current.bbNum = bbNum;
                current.tacList = start;
                switch (end.opc) {
                    case RETURN:
                        current.endKind = BasicBlock.EndKind.BY_RETURN;
                        current.var = end.op0;
                        current.next[0] = current.next[1] = -1; // Special case.
                        end = end.prev;
                        break;
                    // for branch, beqz, bnez, the label of the Tac is the target
                    case BRANCH:
                        current.endKind = BasicBlock.EndKind.BY_BRANCH;
                        current.next[0] = current.next[1] = end.label.where.bbNum;
                        end = end.prev;
                        break;
                    case BEQZ:
                    case BNEZ:
                        current.endKind = end.opc == Kind.BEQZ ? BasicBlock.EndKind.BY_BEQZ
                                : BasicBlock.EndKind.BY_BNEZ;
                        current.var = end.op0;
                        current.next[0] = end.label.where.bbNum;
                        current.next[1] = nextStart.bbNum;
                        end = end.prev;
                        break;
                    default:
                        // basic blocks that don't end with jump
                        if (nextStart == null) {
                            current.endKind = BasicBlock.EndKind.BY_RETURN;
                            current.next[0] = current.next[1] = -1;
                        } else {
                            current.endKind = BasicBlock.EndKind.BY_BRANCH;
                            current.next[0] = current.next[1] = nextStart.bbNum;
                        }
                }
                if (end == null) {
                    current.tacList = null;
                } else {
                    end.next = null;
                }
            }
            bbs.add(current);
        }
    }

    @Override
    public Iterator<BasicBlock> iterator() {
        return bbs.iterator();
    }

    public BasicBlock getBlock(int i) {
        return bbs.get(i);
    }

    public int size() {
        return bbs.size();
    }

    public void resolveDUChain() {
        for (BasicBlock bb: bbs) {
            for (BasicBlock b: bbs)
                b.visited = 0;
            for (int i = 0; i < 2; ++i) {
                if (bb.next[i] >= 0) {
                    Set<Temp> copyDef = new TreeSet<Temp>(Temp.ID_COMPARATOR);
                    copyDef.addAll(bb.redef);
                    computedefDU(bb, bbs.get(bb.next[i]), copyDef);
                }
            }
        }

        boolean changed;
        do {
            changed = false;
            boolean adderror = false;
            for (BasicBlock bb : bbs) {
                for (int i = 0; i < 2; i++) {
                    if (bb.next[i] >= 0) {
//                            if (!bb.liveOutDU.contains(debug) &&
//                                    bbs.get(bb.next[i]).liveInDU.contains(debug)) {
//                                System.out.println(bb.bbNum + " from liveInDU " + bb.next[i]);
//                                adderror = true;
//                            }
                            bb.liveOutDU.addAll(bbs.get(bb.next[i]).liveInDU);
                    }
                }
                bb.liveOutDU.removeAll(bb.defDU);
//                if (adderror && bb.liveOutDU.contains(debug)) {
//                    System.out.println("**************************");
//                    System.out.println("add to " + bb.bbNum + " liveInDU");
//                    adderror = false;
//                }

                int a = 0;
                //Set<Pair> b = bbs.get(bb.next[1]).liveInDU;
                if (bb.liveInDU.addAll(bb.liveOutDU))
                    changed = true;
                for (int i = 0; i < 2; i++) {
                    if (bb.next[i] >= 0) {
//                        if (!bb.liveOutDU.contains(debug) &&
//                                bbs.get(bb.next[i]).liveInDU.contains(debug)) {
//                            System.out.println("add to " + bb.bbNum + " liveOutDU from liveInDU " + bb.next[i]);
//                            adderror = true;
//                        }
                        bb.liveOutDU.addAll(bbs.get(bb.next[i]).liveInDU);
                    }
                }
            }
        } while (changed);
    }

    public void computedefDU(BasicBlock bb, BasicBlock next, Set<Temp> copyDef) {
//        System.out.println(next.bbNum);
//        if (bb.tacList.id == 39)
//            System.out.println("start");
        ++next.visited;
//        if (bb.bbNum == 16) {
//            System.out.println(next.bbNum + " " + next.visited);
//            System.out.println(copyDef.toString());
//            System.out.println(next.liveUse.toString());
//        }
        for (Temp temp: next.liveUse) {
            if (copyDef.contains(temp)) {
                for (Pair pair : next.liveUseDU)
                    if (pair.tmp == temp)
                        bb.defDU.add(pair);
            }
        }
        copyDef.removeAll(next.redef);
        int i = (next.next[0] == next.next[1]) ? 1: 0;
        for (; i < 2; ++i) {
            if (!copyDef.isEmpty() && next.next[i] >= 0) {
                Set<Temp> copy = new TreeSet<Temp>(Temp.ID_COMPARATOR);
                copy.addAll(copyDef);
                if (bbs.get(next.next[i]).visited == 0)
                    computedefDU(bb, bbs.get(next.next[i]), copy);
            }
        }
        --next.visited;
    }
    public void analyzeLiveness() {
        for (BasicBlock bb: bbs) {
            // also initialize liveIn to liveUse
            bb.computeDefAndLiveUse();
        }
        boolean changed;
        do {
            changed = false;
            for (BasicBlock bb : bbs) {
                for (int i = 0; i < 2; i++) {
                    if (bb.next[i] >= 0) { // Not RETURN
                        bb.liveOut.addAll(bbs.get(bb.next[i]).liveIn);
                    }
                }
                bb.liveOut.removeAll(bb.def);
                if (bb.liveIn.addAll(bb.liveOut))
                    changed = true;
                for (int i = 0; i < 2; i++) {
                    if (bb.next[i] >= 0) {
                        bb.liveOut.addAll(bbs.get(bb.next[i]).liveIn);
                    }
                }
            }
        } while (changed);
    }

    public void simplify() {
        getBlock(0).inDegree = 1;
        for (BasicBlock bb : bbs) {
            switch (bb.endKind) {
                case BY_BEQZ:
                case BY_BNEZ:
                    getBlock(bb.next[1]).inDegree++;
                case BY_BRANCH:
                    getBlock(bb.next[0]).inDegree++;
                    break;
            }
        }
        for (BasicBlock bb : bbs) {
            if (bb.inDegree <= 0
                    || (bb.endKind == BasicBlock.EndKind.BY_BRANCH && bb.tacList == null)) {
                bb.cancelled = true;
            }
        }
        for (BasicBlock bb : bbs) {
            if (bb.cancelled || bb.endKind == BasicBlock.EndKind.BY_RETURN) {
                continue;
            }
            BasicBlock trace = getBlock(bb.next[0]);
            // skip dead blocks
            while (trace.cancelled) {
                trace = getBlock(trace.next[0]);
            }
            bb.next[0] = trace.bbNum;

            // skip dead blocks in false branch
            if (bb.endKind == BasicBlock.EndKind.BY_BEQZ
                    || bb.endKind == BasicBlock.EndKind.BY_BNEZ) {
                trace = getBlock(bb.next[1]);
                while (trace.cancelled) {
                    trace = getBlock(trace.next[0]);
                }
                bb.next[1] = trace.bbNum;
                // merge false and true branches
                if (bb.next[0] == bb.next[1]) {
                    bb.endKind = BasicBlock.EndKind.BY_BRANCH;
                }
            } else {
                bb.next[1] = bb.next[0];
            }
        }

        // set new bbNum for all basic blocks
        Map<Integer, Integer> newBBNum = new HashMap<Integer, Integer>();
        int sz = 0;
        int i = 0;
        for (BasicBlock bb : bbs) {
            if (!bb.cancelled) {
                newBBNum.put(i, sz);
                if (i > sz) {
                    bbs.set(sz, getBlock(i));
                }
                sz++;
            }
            i++;
        }
        bbs = bbs.subList(0, sz);
        for (BasicBlock bb : bbs) {
            bb.bbNum = newBBNum.get(bb.bbNum);
            if (bb.endKind != BasicBlock.EndKind.BY_RETURN) {
                bb.next[0] = newBBNum.get(bb.next[0]);
                bb.next[1] = newBBNum.get(bb.next[1]);
            }
        }
    }

    public void printTo(PrintWriter pw) {
        pw.println("FUNCTION " + functy.label.name + " : ");
        for (BasicBlock bb : bbs) {
            bb.printTo(pw);
        }
    }

    public void printLivenessTo(PrintWriter pw) {
        pw.println("FUNCTION " + functy.label.name + " : ");
        for (BasicBlock bb : bbs) {
            bb.printLivenessTo(pw);
        }
    }

    public void printDUChainTo(PrintWriter pw) {
        pw.println("FUNCTION " + functy.label.name + " : ");
        for (BasicBlock bb : bbs) {
            bb.printDUChainTo(pw);
        }
    }

    public Functy getFuncty() {
        return functy;
    }
}
