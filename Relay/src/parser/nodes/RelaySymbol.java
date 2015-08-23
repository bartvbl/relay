package parser.nodes;

import java_cup.runtime.Symbol;

public class RelaySymbol {

	public final Symbol symbol;
	public final RelaySymbol[] children;

	public RelaySymbol(Symbol symbol, RelaySymbol[] children) {
		this.symbol = symbol;
		this.children = children;
	}

}
