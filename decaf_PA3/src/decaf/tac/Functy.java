package decaf.tac;

import decaf.symbol.Function;

/**
 * @author Deng
 * label: Function label
 * paramMemo: Memo for Tac simulator
 * head: head of the Tac statements of the function body, always Tac.Kind.Mark?
 * tail: tail of the Tac statements of the function body
 * sym: Function symbol associated with this Fucnty
 */
public class Functy {
	public Label label;

	public Tac paramMemo;

	public Tac head;

	public Tac tail;

	public Function sym;
}
