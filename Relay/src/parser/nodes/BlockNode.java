package parser.nodes;

import java_cup.runtime.Symbol;

public class BlockNode extends RelaySymbol {

	public final String name;

	public BlockNode(String name, RelaySymbol childList) {
		super(RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.name = name;
	}

}
