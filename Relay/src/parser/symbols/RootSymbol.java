package parser.symbols;

import parser.symbols.types.RelaySymbolType;
import relay.nodes.BlockNode;
import relay.nodes.RelayNode;
import relay.nodes.RootNode;

public class RootSymbol extends RelaySymbol {
	public final BlockSymbol rootBlock;

	public RootSymbol(BlockSymbol blockSymbol) {
		super(RelaySymbolType.ROOT, new RelaySymbol[]{blockSymbol});
		this.rootBlock = blockSymbol;
	}
	
	@Override
	public String toString() {
		return "Parse tree root node";
	}

	@Override
	public RelayNode compact() {
		BlockNode mainBlock = (BlockNode) rootBlock.compact();
		return new RootNode(mainBlock);
	}
}
