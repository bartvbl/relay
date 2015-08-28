package parser.symbols;

import java.util.ArrayList;

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
			children.add(currentListNode.listItem.compact());
			currentListNode = currentListNode.remainingItems;
		} while(childList.hasItemsRemaining);
		
		RelayNode[] childNodes = children.toArray(new RelayNode[children.size()]);
		
		return new BlockNode(blockName, childNodes);
	}

}
