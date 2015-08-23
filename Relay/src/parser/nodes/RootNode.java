package parser.nodes;

import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.Symbol;

public class RootNode extends RelaySymbol {
	public RootNode(Symbol symbol, BlockNode block) {
		super(symbol, new RelaySymbol[]{block});
	}
}
