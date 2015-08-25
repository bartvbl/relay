package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class BlockNode extends RelaySymbol {

	private final IdentifyerNode nameNode;

	public BlockNode(IdentifyerNode blockName, BlockContentListNode childList) {
		super(RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.nameNode = blockName;
	}

	@Override
	public String toString() {
		return "Block named \"" + nameNode.value + "\"";
	}

	@Override
	public RelaySymbol simplify() {
		return this;
	}
}
