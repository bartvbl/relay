package relay.parser;

import parser.RelaySymbol;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;

public class RelaySymbolFactory implements SymbolFactory {
	
	private int currentSymbolNumber = 1;

	@Override
	public Symbol newSymbol(String name, int id) {
		System.out.println("Function 0 called: " + name + ", " + id);
		return null;
	}

	@Override
	public Symbol newSymbol(String name, int id, Object value) {
		System.out.println("Function 1 called: " + name + ", " + id + ", " + value);
		return null;
	}

	@Override
	public Symbol newSymbol(String name, int id, Symbol left, Symbol right) {
		System.out.println("Function 2 called: " + name + ", " + id + ", " + left + ", " + right);
		return null;
	}

	@Override
	public Symbol newSymbol(String name, int id, Symbol left, Object value) {
		System.out.println("Function 3 called: " + name + ", " + id + ", " + left + ", " + value);
		return null;
	}

	@Override
	public Symbol newSymbol(String name, int id, Symbol left, Symbol right, Object value) {
		System.out.println("Function 4 called: " + name + ", " + id + ", " + left + ", " + right + ", " + value);
		return null;
	}

	@Override
	public Symbol startSymbol(String name, int id, int state) {
		System.out.println("Function 5 called: " + name + ", " + id + ", " + state);
		return new RelaySymbol(name, id, state);
	}

}
