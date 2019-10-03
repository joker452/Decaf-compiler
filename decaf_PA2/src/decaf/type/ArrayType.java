package decaf.type;

public class ArrayType extends Type {

	private Type elementType;

	public Type getElementType() {
		return elementType;
	}
	
	/**
	 * specify the element type of the array
	 */
	public ArrayType(Type elementType) {
		this.elementType = elementType;
	}

	/**
	 * true when type is BaseType.ERROR or
	 * type is ArrayType and its elementType compatible to 
	 * the same as this.elementType
	 */
	@Override
	public boolean compatible(Type type) {
		if (type.equal(BaseType.ERROR)) {
			return true;
		}
		return equal(type);
	}

	@Override
	public boolean equal(Type type) {
		if (!type.isArrayType()) {
			return false;
		}
		return elementType.equal(((ArrayType) type).elementType);
	}

	@Override
	public String toString() {
		return elementType + "[]";
	}

	@Override
	public boolean isArrayType() {
		return true;
	}
}
