package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class BlockContentListNode extends RelaySymbol {
	public final BlockContentItemNode listItem;
	public final BlockContentListNode remainingItems;
	public final BlockContentItemNode[] contentsList;
	
	public BlockContentListNode(BlockContentItemNode listItem, BlockContentListNode remainingItems) {
		super(RelaySymbolType.BLOCK_CONTENT_LIST_ITEM, new RelaySymbol[]{listItem, remainingItems});
		this.listItem = listItem;
		this.remainingItems = remainingItems;
		this.contentsList = new BlockContentItemNode[]{listItem};
	}

	public BlockContentListNode(BlockContentItemNode[] totalContents,
			BlockContentListNode remaining, BlockContentItemNode item) {
		super(RelaySymbolType.BLOCK_CONTENT_LIST_ITEM, totalContents);
		this.listItem = item;
		this.remainingItems = remaining;
		this.contentsList = totalContents;
	}

	@Override
	public String toString() {
		return "Block content list";
	}

	@Override
	public RelaySymbol simplify() {
		if(remainingItems == null) {
			return this;
		} else {
			//simplify the child
			BlockContentListNode remainingNodesSimplified = (BlockContentListNode) remainingItems.simplify();
			BlockContentItemNode[] totalContents = new BlockContentItemNode[remainingNodesSimplified.contentsList.length + 1];
			System.arraycopy(remainingNodesSimplified.contentsList, 0, totalContents, 0, remainingNodesSimplified.contentsList.length);
			totalContents[totalContents.length - 1] = listItem;
			return new BlockContentListNode(totalContents, remainingItems, listItem);
		}
	}
	
}
