package decaf.scope;

import java.util.ListIterator;
import java.util.Stack;

import decaf.Location;
import decaf.scope.Scope.Kind;
import decaf.symbol.Class;
import decaf.symbol.Symbol;

public class ScopeStack {
	private Stack<Scope> scopeStack = new Stack<Scope>();
	
	private GlobalScope globalScope;
	
	/**
	 * if through, lookup the symbol in every scope, else only in
	 * the current scope
	 */
	public Symbol lookup(String name, boolean through) {
		if (through) {
			ListIterator<Scope> iter = scopeStack.listIterator(scopeStack
					.size());
			while (iter.hasPrevious()) {
				Symbol symbol = iter.previous().lookup(name);
				if (symbol != null) {
					return symbol;
				}
			}
			return null;
		} else {
			return scopeStack.peek().lookup(name);
		}
	}


	public Symbol lookupBeforeLocation(String name, Location loc) {
		ListIterator<Scope> iter = scopeStack.listIterator(scopeStack.size());
		while (iter.hasPrevious()) {
			Scope scope = iter.previous();
			Symbol symbol = scope.lookup(name);
			if (symbol != null) {
				if (scope.isLocalScope()
						&& symbol.getLocation().compareTo(loc) > 0) {
					continue;
				}
				return symbol;
			}
		}
		return null;
	}

	public void declare(Symbol symbol) {
		scopeStack.peek().declare(symbol);
	}

	/**
	 * push a scope onto the stack
	 */
	public void open(Scope scope) {
		switch (scope.getKind()) {
		case GLOBAL:
			globalScope = (GlobalScope)scope;
			break;
		case CLASS:
			// if there is a parent class, open it first
			ClassScope cs = ((ClassScope) scope).getParentScope();
			if (cs != null) {
				open(cs);
			}
			break;
		}
		scopeStack.push(scope);
	}

	public void close() {
		Scope scope = scopeStack.pop();
		if (scope.isClassScope()) {
			// pop all the scopes except the GlobalScope
			for (int n = scopeStack.size() - 1; n > 0; n--) {
				scopeStack.pop();
			}
		}
	}

	/**
	 * return the first scope with the specified kind on the stack
	 */
	public Scope lookForScope(Kind kind) {
		ListIterator<Scope> iter = scopeStack.listIterator(scopeStack.size());
		while (iter.hasPrevious()) {
			Scope scope = iter.previous();
			if (scope.getKind() == kind) {
				return scope;
			}
		}
		return null;
	}

	public Scope getCurrentScope() {
		return scopeStack.peek();
	}

	/**
	 * look for a class according to its name in globalScope
	 */
	public Class lookupClass(String name) {
		return (Class) globalScope.lookup(name);
	}
}
