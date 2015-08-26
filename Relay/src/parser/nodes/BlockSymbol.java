package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class BlockSymbol extends RelaySymbol {

	private final IdentifyerSYmbol nameNode;

	public BlockSymbol(IdentifyerSYmbol blockName, BlockContentListSymbol childList) {
		super(RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.nameNode = blockName;
	}

	@Override
	public String toString() {
		return "Block named \"" + nameNode.value + "\"";
	}

}
