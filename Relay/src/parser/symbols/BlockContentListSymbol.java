package parser.symbols;

import parser.symbols.types.RelaySymbolType;
import relay.nodes.RelayNode;

public class BlockContentListSymbol extends RelaySymbol {
	public final BlockContentItemSymbol listItem;
	public final BlockContentListSymbol remainingItems;
	public final BlockContentItemSymbol[] contentsList;
	public final boolean hasItemsRemaining;
	
	public BlockContentListSymbol(BlockContentItemSymbol listItem, BlockContentListSymbol remainingItems) {
		super(RelaySymbolType.BLOCK_CONTENT_LIST_ITEM, new RelaySymbol[]{listItem, remainingItems});
		this.listItem = listItem;
		this.remainingItems = remainingItems;
		this.contentsList = new BlockContentItemSymbol[]{listItem};
		this.hasItemsRemaining = remainingItems != null;
	}

	@Override
	public String toString() {
		return "Block content list";
	}

	@Override
	public RelayNode compact() {
		throw new RuntimeException("Can't compact a block content list, has to be done by a Block symbol.");
	}
}
