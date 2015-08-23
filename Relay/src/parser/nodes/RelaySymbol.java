package parser.nodes;

import java_cup.runtime.Symbol;

public class RelaySymbol {

	public final Symbol symbol;
	public final Symbol[] children;

	public RelaySymbol(Symbol symbol, Symbol[] symbols) {
		this.symbol = symbol;
		this.children = symbols;
	}

}
