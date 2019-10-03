package decaf.type;

import decaf.scope.ClassScope;
import decaf.symbol.Class;

public class ClassType extends Type {

	private Class symbol;

	private ClassType parent;

	public ClassType(Class symbol, ClassType parent) {
		this.symbol = symbol;
		this.parent = parent;
	}

	/**
	 * true when type is BaseType.ERROR
	 * of type is a parent class of this
	 */
	@Override
	public boolean compatible(Type type) {
		if (type.equal(BaseType.ERROR)) {
			return true;
		}
		if (!type.isClassType()) {
			return false;
		}
		for (ClassType t = this; t != null; t = t.parent) {
			if (t.equal(type)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * equal only when type is ClassType and type shares
	 * the same Class reference with this.symbol
	 */
	@Override
	public boolean equal(Type type) {
		return type.isClassType() && symbol == ((ClassType) type).symbol;
	}

	@Override
	public boolean isClassType() {
		return true;
	}

	@Override
	public String toString() {
		return "class : " + symbol.getName();
	}

	public Class getSymbol() {
		return symbol;
	}

	public ClassType getParentType() {
		return parent;
	}

	public ClassScope getClassScope() {
		return symbol.getAssociatedScope();
	}

}
