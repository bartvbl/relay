package parser.symbols;

import java.util.ArrayList;

import parser.symbols.types.BlockItemType;
import parser.symbols.types.RelaySymbolType;
import relay.nodes.BlockNode;
import relay.nodes.RelayNode;

public class BlockSymbol extends RelaySymbol {

	public final IdentifyerSymbol nameNode;
	public final BlockContentListSymbol childList;

	public BlockSymbol(IdentifyerSymbol blockName, BlockContentListSymbol childList) {
		super(RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.nameNode = blockName;
		this.childList = childList;
	}

	@Override
	public String toString() {
		return "Block named \"" + nameNode.value + "\"";
	}

	@Override
	public RelayNode compact() {
		String blockName = nameNode.value;
		ArrayList<RelayNode> children = new ArrayList<RelayNode>();
		BlockContentListSymbol currentListNode = childList;
		
		do {
			BlockContentItemSymbol currentChild = (BlockContentItemSymbol) currentListNode.listItem;
			if(currentChild.itemType != BlockItemType.EMPTY) { // ensure empty block items are filtered out. Side effect of newlines having meaning in the grammar				
				children.add(currentListNode.listItem.compact());
			}
			currentListNode = currentListNode.remainingItems;
		} while(currentListNode.hasItemsRemaining);
		children.add(currentListNode.listItem.compact()); //Add the final item
		
		RelayNode[] childNodes = children.toArray(new RelayNode[children.size()]);
		
		return new BlockNode(blockName, childNodes);
	}

}
