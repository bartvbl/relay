package parser.nodes;

import java_cup.runtime.Symbol;

public class BlockNode extends RelaySymbol {

	public BlockNode(Symbol symbol, RelaySymbol[] children) {
		super(symbol, children);
	}

}
