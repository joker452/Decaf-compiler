package decaf.dataflow;

import java.io.PrintWriter;
import java.util.*;

import decaf.machdesc.Asm;
import decaf.machdesc.Register;
import decaf.tac.Label;
import decaf.tac.Tac;
import decaf.tac.Temp;

public class BasicBlock {
    public int bbNum; // set by gatherBasicBlocks in FlowGraph

    public enum EndKind {
        BY_BRANCH, BY_BEQZ, BY_BNEZ, BY_RETURN
    }

    public EndKind endKind;

    public int endId; // last TAC's id for this basic block

    public int inDegree; // the number of basic blocks that can reach this basic block

    public Tac tacList; // the head of the tacs of the block

    public Label label; // assembly code start number

    public Temp var; // target operand for the exit statement

    public Register varReg; //register for exit statement

    public int[] next; // at most two, next bbNum

    public boolean cancelled; // flag for dead block

    public boolean mark; // flag for output assembly code

    public int visited = 0;

    public Set<Temp> def;

    public Set<Temp> redef;

    public Set<Pair> defDU;

    public Set<Temp> liveUse;

    public Set<Pair> liveUseDU;

    public Set<Temp> liveIn;

    public Set<Pair> liveInDU;

    public Set<Temp> liveOut;

    public Set<Pair> liveOutDU;

    public Set<Temp> saves; // variables in registers that must be saved  when leave

    private List<Asm> asms; // assembly instructiosn for this basic block

    /**
     * DUChain.
     * <p>
     * 表中的每一项 `Pair(p, A) -> ds` 表示 变量 `A` 在定值点 `p` 的 DU 链为 `ds`.
     * 这里 `p` 和 `ds` 中的每一项均指的定值点或引用点对应的那一条 TAC 的 `id`.
     */
    private Map<Pair, Set<Integer>> DUChain;

    public BasicBlock() {
        def = new TreeSet<Temp>(Temp.ID_COMPARATOR);
        defDU = new TreeSet<Pair>(Pair.COMPARATOR);
        redef = new TreeSet<Temp>(Temp.ID_COMPARATOR);
        liveUse = new TreeSet<Temp>(Temp.ID_COMPARATOR);
        liveUseDU = new TreeSet<Pair>(Pair.COMPARATOR);
        liveIn = new TreeSet<Temp>(Temp.ID_COMPARATOR);
        liveInDU = new TreeSet<Pair>(Pair.COMPARATOR);
        liveOut = new TreeSet<Temp>(Temp.ID_COMPARATOR);
        liveOutDU = new TreeSet<Pair>(Pair.COMPARATOR);
        next = new int[2];
        asms = new ArrayList<Asm>();

        DUChain = new TreeMap<Pair, Set<Integer>>(Pair.COMPARATOR);
    }

    public void allocateTacIds() {
        for (Tac tac = tacList; tac != null; tac = tac.next) {
            tac.id = IDAllocator.apply();
        }
        endId = IDAllocator.apply();
    }

    public void computeDefAndLiveUse() {
        for (Tac tac = tacList; tac != null; tac = tac.next) {
            switch (tac.opc) {
                case ADD:
                case SUB:
                case MUL:
                case DIV:
                case MOD:
                case LAND:
                case LOR:
                case GTR:
                case GEQ:
                case EQU:
                case NEQ:
                case LEQ:
                case LES:
                    /* use op1 and op2, def op0 */
                    if (tac.op1.lastVisitedBB != bbNum) {
                        liveUse.add(tac.op1);
                        tac.op1.lastVisitedBB = bbNum;
                    }

                    if (!redef.contains(tac.op1))
                        liveUseDU.add(new Pair(tac.id, tac.op1));

                    if (tac.op2.lastVisitedBB != bbNum) {
                        liveUse.add(tac.op2);
                        tac.op2.lastVisitedBB = bbNum;
                    }

                    if (!redef.contains(tac.op2))
                        liveUseDU.add(new Pair(tac.id, tac.op2));

                    if (tac.op0.lastVisitedBB != bbNum) {
                        def.add(tac.op0);
                        tac.op0.lastVisitedBB = bbNum;
                    }

                    redef.add(tac.op0);

                    break;
                case NEG:
                case LNOT:
                case ASSIGN:
                case INDIRECT_CALL:
                case LOAD:
                    /* use op1, def op0 */

                    if (tac.op1.lastVisitedBB != bbNum) {
                        liveUse.add(tac.op1);
                        tac.op1.lastVisitedBB = bbNum;
                    }

                    if (!redef.contains(tac.op1))
                        liveUseDU.add(new Pair(tac.id, tac.op1));

                    if (tac.op0 != null) {  // in INDIRECT_CALL with return type VOID,
                        // tac.op0 is null
                        redef.add(tac.op0);
                        if (tac.op0.lastVisitedBB != bbNum) {
                            def.add(tac.op0);
                            tac.op0.lastVisitedBB = bbNum;
                        }
                    }
                    break;
                case LOAD_VTBL:
                case DIRECT_CALL:
                case RETURN:
                case LOAD_STR_CONST:
                case LOAD_IMM4:
                    /* def op0 */
                    if (tac.op0 != null) {  // in DIRECT_CALL with return type VOID,
                        // tac.op0 is null
                        if (tac.op0.lastVisitedBB != bbNum) {
                            def.add(tac.op0);
                            tac.op0.lastVisitedBB = bbNum;
                        }
                        redef.add(tac.op0);
                    }
                    break;
                case STORE:
                    /* use op0 and op1*/
                    if (tac.op0.lastVisitedBB != bbNum) {
                        liveUse.add(tac.op0);
                        tac.op0.lastVisitedBB = bbNum;
                    }

                    if (!redef.contains(tac.op0))
                        liveUseDU.add(new Pair(tac.id, tac.op0));

                    if (tac.op1.lastVisitedBB != bbNum) {
                        liveUse.add(tac.op1);
                        tac.op1.lastVisitedBB = bbNum;
                    }

                    if (!redef.contains(tac.op1))
                        liveUseDU.add(new Pair(tac.id, tac.op1));
                    break;
                case PARM:
                    /* use op0 */
                    if (tac.op0.lastVisitedBB != bbNum) {
                        liveUse.add(tac.op0);
                        tac.op0.lastVisitedBB = bbNum;
                    }

                    if (!redef.contains(tac.op0))
                        liveUseDU.add(new Pair(tac.id, tac.op0));
                    break;
                default:
                    /* BRANCH MEMO MARK PARM*/
                    break;
            }
        }
        if (var != null && var.lastVisitedBB != bbNum) {
            liveUse.add(var);
            var.lastVisitedBB = bbNum;
        }
        if (var != null && !redef.contains(var))
            liveUseDU.add(new Pair(endId, var));
        liveIn.addAll(liveUse);
        liveInDU.addAll(liveUseDU);
    }

    public void resolveDUChain() {
        if (tacList == null)
            return;
        Tac tac = tacList;
        for (; tac != null; tac = tac.next) {
            if (tac.isGenerator()) {
                boolean defined = false;
                Tac current = tac.next;
                Set<Integer> usages = new TreeSet<Integer>();
                while (current != null && !defined) {
                    switch (current.opc) {
                        case ADD:
                        case SUB:
                        case MUL:
                        case DIV:
                        case MOD:
                        case LAND:
                        case LOR:
                        case GTR:
                        case GEQ:
                        case EQU:
                        case NEQ:
                        case LEQ:
                        case LES:
                            /* use op1 and op2, def op0 */
                            if (current.op1 == tac.op0)
                                usages.add(current.id);
                            else if (current.op2 == tac.op0)
                                usages.add(current.id);
                            if (current.op0 != null && current.op0 == tac.op0)
                                defined = true;
                            break;
                        case NEG:
                        case LNOT:
                        case ASSIGN:
                        case INDIRECT_CALL:
                        case LOAD:
                            /* use op1, def op0 */
                            if (current.op1 == tac.op0)
                                usages.add(current.id);
                            if (current.op0 != null && current.op0 == tac.op0)
                                defined = true;
                            break;
                        case LOAD_VTBL:
                        case DIRECT_CALL:
                        case RETURN:
                        case LOAD_STR_CONST:
                        case LOAD_IMM4:
                            /* def op0 */
                            if (current.op0 != null && current.op0 == tac.op0)
                                defined = true;
                            break;
                        case STORE:
                            /* use op0 and op1*/
                            if (current.op0 == tac.op0)
                                usages.add(current.id);
                            else if (current.op1 == tac.op0)
                                usages.add(current.id);
                            break;
                        case BEQZ:
                        case BNEZ:
                        case PARM:
                            /* use op0 */
                            if (current.op0 == tac.op0)
                                usages.add(current.id);
                            break;
                        default:
                            /* BRANCH MEMO MARK */
                            break;
                    }
                    current = current.next;
                }

                if (!defined) {
                    if (var != null && var == tac.op0)
                        usages.add(endId);
                    for (Pair p : liveOutDU)
                        if (p.tmp == tac.op0)
                            usages.add(p.pos);
                }
                if (!usages.isEmpty())
                    DUChain.put(new Pair(tac.id, tac.op0), usages);
            }
        }

    }

    public void analyzeLiveness() {
        if (tacList == null)
            return;
        Tac tac = tacList;
        // stop at the end
        for (; tac.next != null; tac = tac.next);

        tac.liveOut = new HashSet<Temp>(liveOut);
        if (var != null)
            tac.liveOut.add(var);
        for (; tac != tacList; tac = tac.prev) {
            // let LiveIn equal LiveOut, then remove Def and add LiveUse
            tac.prev.liveOut = new HashSet<Temp>(tac.liveOut);
            switch (tac.opc) {
                // 13
                case ADD:
                case SUB:
                case MUL:
                case DIV:
                case MOD:
                case LAND:
                case LOR:
                case GTR:
                case GEQ:
                case EQU:
                case NEQ:
                case LEQ:
                case LES:
                    /* use op1 and op2, def op0 */
                    tac.prev.liveOut.remove(tac.op0);
                    tac.prev.liveOut.add(tac.op1);
                    tac.prev.liveOut.add(tac.op2);
                    break;
                // 5
                case NEG:
                case LNOT:
                case ASSIGN:
                case INDIRECT_CALL:
                case LOAD:
                    /* use op1, def op0 */
                    tac.prev.liveOut.remove(tac.op0);
                    tac.prev.liveOut.add(tac.op1);
                    break;
                // 5
                case LOAD_VTBL:
                case DIRECT_CALL:
                case RETURN:
                case LOAD_STR_CONST:
                case LOAD_IMM4:
                    /* def op0 */
                    tac.prev.liveOut.remove(tac.op0);
                    break;
                case STORE:
                    /* use op0 and op1*/
                    tac.prev.liveOut.add(tac.op0);
                    tac.prev.liveOut.add(tac.op1);
                    break;
                case BEQZ:
                case BNEZ:
                case PARM:
                    /* use op0 */
                    tac.prev.liveOut.add(tac.op0);
                    break;
                default:
                    /* BRANCH MEMO MARK */
                    break;
            }
        }
    }

    private void printEnd(PrintWriter pw) {
        switch (endKind) {
            case BY_BRANCH:
                pw.println("END BY BRANCH, goto " + next[0]);
                break;
            case BY_BEQZ:
                pw.println("END BY BEQZ, if " + var.name + " = ");
                pw.println("    0 : goto " + next[0] + "; 1 : goto " + next[1]);
                break;
            case BY_BNEZ:
                pw.println("END BY BGTZ, if " + var.name + " = ");
                pw.println("    1 : goto " + next[0] + "; 0 : goto " + next[1]);
                break;
            case BY_RETURN:
                if (var != null) {
                    pw.println("END BY RETURN, result = " + var.name);
                } else {
                    pw.println("END BY RETURN, void result");
                }
                break;
        }
    }

    public void printTo(PrintWriter pw) {
        pw.println("BASIC BLOCK " + bbNum + " : ");
        for (Tac t = tacList; t != null; t = t.next) {
            pw.println("    " + t);
        }
        printEnd(pw);
    }

    public void printLivenessTo(PrintWriter pw) {
        pw.println("BASIC BLOCK " + bbNum + " : ");
        pw.println("  Def     = " + toString(def));
        pw.println("  defDU   = " + printPair(defDU));
        pw.println("  redef   = " + toString(redef));
        pw.println("  liveUseDU = " + printPair(liveUseDU));
        pw.println("  liveUse = " + toString(liveUse));
        pw.println("  liveIn  = " + toString(liveIn));
        pw.println("  liveInDU = " + printPair(liveInDU));
        pw.println("  liveOut = " + toString(liveOut));
        pw.println("  liveOutDU = " + printPair(liveOutDU));
        for (Tac t = tacList; t != null; t = t.next) {
            pw.println("    " + t.id + " " + t + " " + toString(t.liveOut));
        }
        printEnd(pw);
    }

    public void printDUChainTo(PrintWriter pw) {
        pw.println("BASIC BLOCK " + bbNum + " : ");

        for (Tac t = tacList; t != null; t = t.next) {
            pw.print(t.id + "\t" + t);

            Pair pair = null;
            switch (t.opc) {
                case ADD:
                case SUB:
                case MUL:
                case DIV:
                case MOD:
                case LAND:
                case LOR:
                case GTR:
                case GEQ:
                case EQU:
                case NEQ:
                case LEQ:
                case LES:
                case NEG:
                case LNOT:
                case ASSIGN:
                case INDIRECT_CALL:
                case LOAD:
                case LOAD_VTBL:
                case DIRECT_CALL:
                case RETURN:
                case LOAD_STR_CONST:
                case LOAD_IMM4:
                    if (t.op0 != null) {
                        pair = new Pair(t.id, t.op0);
                    }
                    break;
                case STORE:
                case BEQZ:
                case BNEZ:
                case PARM:
                    break;
                default:
                    /* BRANCH MEMO MARK PARM */
                    break;
            }

            if (pair == null) {
                pw.println();
            } else {
                pw.print(" [ ");
                Set<Integer> locations = DUChain.get(pair);
                if (locations != null) {
                    for (Integer loc : locations) {
                        pw.print(loc + " ");
                    }
                }
                pw.println("]");
            }
        }

        pw.print(endId + "\t");

        switch (endKind) {
            case BY_BRANCH:
                pw.println("END BY BRANCH, goto " + next[0]);
                break;
            case BY_BEQZ:
                pw.println("END BY BEQZ, if " + var.name + " = ");
                pw.println("\t    0 : goto " + next[0] + "; 1 : goto " + next[1]);
                break;
            case BY_BNEZ:
                pw.println("END BY BGTZ, if " + var.name + " = ");
                pw.println("\t    1 : goto " + next[0] + "; 0 : goto " + next[1]);
                break;
            case BY_RETURN:
                if (var != null) {
                    pw.println("END BY RETURN, result = " + var.name);
                } else {
                    pw.println("END BY RETURN, void result");
                }
                break;
        }
    }

    public String toString(Set<Temp> set) {
        StringBuilder sb = new StringBuilder("[ ");
        for (Temp t : set) {
            sb.append(t.name + " ");
        }
        sb.append(']');
        return sb.toString();
    }

    // debug print function
    public String printPair(Set<Pair> set) {
        StringBuilder sb = new StringBuilder("[ ");
        for (Pair p : set) {
            sb.append(p.toString() + " ");
        }
        sb.append(']');
        return sb.toString();
    }

    public void insertBefore(Tac insert, Tac base) {
        if (base == tacList) {
            tacList = insert;
        } else {
            base.prev.next = insert;
        }
        insert.prev = base.prev;
        base.prev = insert;
        insert.next = base;
    }

    public void insertAfter(Tac insert, Tac base) {
        if (tacList == null) {
            tacList = insert;
            insert.next = null;
            return;
        }
        if (base.next != null) {
            base.next.prev = insert;
        }
        insert.prev = base;
        insert.next = base.next;
        base.next = insert;
    }

    public void appendAsm(Asm asm) {
        asms.add(asm);
    }

    public List<Asm> getAsms() {
        return asms;
    }
}
