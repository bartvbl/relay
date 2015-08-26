package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class BlockContentListSymbol extends RelaySymbol {
	public final BlockContentItemSymbol listItem;
	public final BlockContentListSymbol remainingItems;
	public final BlockContentItemSymbol[] contentsList;
	
	public BlockContentListSymbol(BlockContentItemSymbol listItem, BlockContentListSymbol remainingItems) {
		super(RelaySymbolType.BLOCK_CONTENT_LIST_ITEM, new RelaySymbol[]{listItem, remainingItems});
		this.listItem = listItem;
		this.remainingItems = remainingItems;
		this.contentsList = new BlockContentItemSymbol[]{listItem};
	}

	public BlockContentListSymbol(BlockContentItemSymbol[] totalContents,
			BlockContentListSymbol remaining, BlockContentItemSymbol item) {
		super(RelaySymbolType.BLOCK_CONTENT_LIST_ITEM, totalContents);
		this.listItem = item;
		this.remainingItems = remaining;
		this.contentsList = totalContents;
	}

	@Override
	public String toString() {
		return "Block content list";
	}
	
	/*
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
	*/
}
