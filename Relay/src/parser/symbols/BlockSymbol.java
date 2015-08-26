package parser.symbols;

import parser.symbols.types.RelaySymbolType;

public class BlockSymbol extends RelaySymbol {

	private final IdentifyerSymbol nameNode;

	public BlockSymbol(IdentifyerSymbol blockName, BlockContentListSymbol childList) {
		super(RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.nameNode = blockName;
	}

	@Override
	public String toString() {
		return "Block named \"" + nameNode.value + "\"";
	}

}
