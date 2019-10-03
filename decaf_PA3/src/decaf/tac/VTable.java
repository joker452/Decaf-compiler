package decaf.tac;

/**
 * @author Deng
 * name: name of the VTable
 * parent: VTable of the superclass of this class
 * className: name of the class that this VTable belongs to
 * entries: Labels of the member functions (nonstatic)
 */
public class VTable {
	public String name;
	
	public VTable parent;
	
	public String className;

	public Label[] entries;
}
