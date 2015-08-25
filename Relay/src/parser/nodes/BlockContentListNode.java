package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class BlockContentListNode extends RelaySymbol {
	public BlockContentListNode(BlockContentItemNode listItem, BlockContentListNode remainingItems) {
		super(RelaySymbolType.BLOCK_CONTENT_LIST_ITEM, new RelaySymbol[]{listItem, remainingItems});
	}
	
	@Override
	public String toString() {
		return "Block content list";
	}
	
}
