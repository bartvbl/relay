package parser.symbols;

import parser.symbols.types.RelaySymbolType;

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
}
