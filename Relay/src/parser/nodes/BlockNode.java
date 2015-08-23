package parser.nodes;

import java_cup.runtime.Symbol;

public class BlockNode extends RelaySymbol {

	public final String name;

	public BlockNode(Symbol symbol, String name, Symbol children) {
		super(symbol, new Symbol[]{children});
		this.name = name;
	}

}
