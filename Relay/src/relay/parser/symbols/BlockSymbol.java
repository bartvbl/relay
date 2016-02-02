package relay.parser.symbols;

import java.util.ArrayList;
import java.util.HashMap;

import relay.exceptions.RelayException;
import relay.layout.BlockDimensions;
import relay.nodes.BlockNode;
import relay.nodes.BlockPropertyNode;
import relay.nodes.CodeBlockNode;
import relay.nodes.RelayNode;
import relay.parser.symbols.types.BlockItemType;
import relay.parser.symbols.types.RelaySymbolType;

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
	public RelayNode compact() throws RelayException {
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
		
		ArrayList<BlockNode> childBlockList = new ArrayList<BlockNode>();
		ArrayList<CodeBlockNode> codeBlockList = new ArrayList<CodeBlockNode>();
		ArrayList<BlockPropertyNode> blockPropertyList = new ArrayList<BlockPropertyNode>();
		
		for(RelayNode child : childNodes) {
			if(child instanceof BlockNode) {
				childBlockList.add((BlockNode) child);
			} else if(child instanceof CodeBlockNode) {
				codeBlockList.add((CodeBlockNode) child);
			} else if(child instanceof BlockPropertyNode) {
				blockPropertyList.add((BlockPropertyNode) child);
			} else {
				throw new RuntimeException("Unknown node: " + child);
			}
		}
		
		BlockNode[] childBlocks = childBlockList.toArray(new BlockNode[childBlockList.size()]);
		CodeBlockNode[] childCodeBlocks = codeBlockList.toArray(new CodeBlockNode[codeBlockList.size()]);
		BlockPropertyNode[] blockProperties = blockPropertyList.toArray(new BlockPropertyNode[blockPropertyList.size()]);
		
		HashMap<String, BlockPropertyNode> propertyMap = new HashMap<String, BlockPropertyNode>();
		for(BlockPropertyNode property : blockProperties) {
			propertyMap.put(property.identifyer, property);
		}
		
		BlockDimensions dimensions = new BlockDimensions(propertyMap);	
		
		return new BlockNode(blockName, childNodes, childBlocks, childCodeBlocks, propertyMap, dimensions);
	}

}
