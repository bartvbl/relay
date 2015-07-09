package relay.parser;

import parser.RelaySymbol;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;

public class RelaySymbolFactory implements SymbolFactory {
	
	private int currentSymbolNumber = 1;

	@Override
	public Symbol newSymbol(String arg0, int arg1) {
		System.out.println("Function 0 called: " + arg0 + ", " + arg1);
		return null;
	}

	@Override
	public Symbol newSymbol(String arg0, int arg1, Object arg2) {
		System.out.println("Function 1 called: " + arg0 + ", " + arg1 + ", " + arg2);
		return null;
	}

	@Override
	public Symbol newSymbol(String arg0, int arg1, Symbol arg2, Symbol arg3) {
		System.out.println("Function 2 called: " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3);
		return null;
	}

	@Override
	public Symbol newSymbol(String arg0, int arg1, Symbol arg2, Object arg3) {
		System.out.println("Function 3 called: " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3);
		return null;
	}

	@Override
	public Symbol newSymbol(String arg0, int arg1, Symbol arg2, Symbol arg3, Object arg4) {
		System.out.println("Function 4 called: " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4);
		return null;
	}

	@Override
	public Symbol startSymbol(String name, int line, int column) {
		System.out.println("Function 5 called: " + name + ", " + line + ", " + column);
		return new RelaySymbol(currentSymbolNumber, name, line, column);
	}

}
