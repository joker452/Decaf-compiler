package decaf.scope;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import decaf.symbol.Symbol;
import decaf.utils.IndentPrintWriter;

/**
 * 
 * abstract class for scope in decaf
 * four kinds of scope are defined, i.e., GLOBAL, CLASS, FORMAL, LOCAL
 */
public abstract class Scope {
	public enum Kind {
		GLOBAL, CLASS, FORMAL, LOCAL
	}

	// Map a symbol's name to a symbol
	protected Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();

	public abstract Kind getKind();

	public abstract void printTo(IndentPrintWriter pw);

	public boolean isGlobalScope() {
		return false;
	}

	public boolean isClassScope() {
		return false;
	}

	public boolean isLocalScope() {
		return false;
	}

	public boolean isFormalScope() {
		return false;
	}

	public Symbol lookup(String name) {
		return symbols.get(name);
	}

	/**
	 * add a symbol to the symbol table, 
	 * if there is a namesake, replace it
	 */
	public void declare(Symbol symbol) {
		symbols.put(symbol.getName(), symbol);
		symbol.setScope(this);
	}

	/**
	 * remove a symbol from the symbol table
	 */
	public void cancel(Symbol symbol) {
		symbols.remove(symbol.getName());
	}

	/**
	 * return a iterator of the value (symbol), note changes will be seen
	 * it's an undefined behavior if the map is modified when iterating
	 */
	public Iterator<Symbol> iterator() {
		return symbols.values().iterator();
	}

}
