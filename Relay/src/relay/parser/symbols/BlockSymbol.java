package relay.parser.symbols;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import relay.exceptions.RelayException;
import relay.exceptions.RelayRuntimeException;
import relay.layout.BlockDimensions;
import relay.nodes.BlockNode;
import relay.nodes.BlockPropertyNode;
import relay.nodes.RelayNode;
import relay.nodes.RepeatDefinitionNode;
import relay.nodes.VariableDefinitionNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BlockItemType;
import relay.parser.symbols.types.RelaySymbolType;
import relay.types.BlockType;
import relay.types.RelayBlockPropertyType;
import relay.util.RelayUtil;

public class BlockSymbol extends RelaySymbol {

	public final IdentifyerSymbol blockTypeNode;
	public final BlockContentListSymbol childList;
	public final BlockDetailsSymbol blockDetails;
	

	public BlockSymbol(LocationRange locationRange, BlockDetailsSymbol blockDetails, BlockContentListSymbol childList) {
		super(locationRange, RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.blockTypeNode = null;
		this.childList = childList;
		this.blockDetails = blockDetails;
	}
	
	@Override
	public String toString() {
		return "Block named \"" + blockDetails.blockName.value + "\"";
	}

	@Override
	public RelayNode compact() throws RelayException {
		String blockName = (blockDetails.blockName == null) ? "block_" + RelayUtil.generateUUID() : blockDetails.blockName.value;
		BlockType blockType;
		try {
			blockType = (blockTypeNode == null) ? BlockType.Basic : BlockType.valueOf(this.blockTypeNode.value);
		} catch(Exception e) {
			throw new RelayException("The block type \"" + this.blockTypeNode.value + "\" is not known. Did you mistype it?", location);
		}
		ArrayList<RelayNode> children = new ArrayList<RelayNode>();
		BlockContentListSymbol currentListNode = childList;
		
		if(currentListNode == null) {
			throw new RelayRuntimeException("Defining an empty block is not allowed.", location);
		}
		
		do {
			BlockContentItemSymbol currentChild = (BlockContentItemSymbol) currentListNode.listItem;
			if(currentChild == null) {
				currentListNode = currentListNode.remainingItems;
				continue;
			}
			if(currentChild.itemType != BlockItemType.EMPTY) { // ensure empty block items are filtered out. Side effect of newlines having meaning in the grammar				
				children.add(currentListNode.listItem.compact());
			}
			currentListNode = currentListNode.remainingItems;
		} while(currentListNode.hasItemsRemaining);

		if(currentListNode.listItem != null) {
			children.add(currentListNode.listItem.compact()); //Add the final item
		}
		Collections.reverse(children);
		
		RelayNode[] childNodes = children.toArray(new RelayNode[children.size()]);
		
		ArrayList<BlockNode> childBlockList = new ArrayList<BlockNode>();
		ArrayList<BlockPropertyNode> blockPropertyList = new ArrayList<BlockPropertyNode>();
		ArrayList<VariableDefinitionNode> variableDefinitionList = new ArrayList<VariableDefinitionNode>();
		ArrayList<RepeatDefinitionNode> repeatDefinitionNodeList = new ArrayList<RepeatDefinitionNode>();
		
		for(RelayNode child : childNodes) {
			if(child instanceof BlockNode) {
				childBlockList.add((BlockNode) child);
			} else if(child instanceof BlockPropertyNode) {
				blockPropertyList.add((BlockPropertyNode) child);
			} else if(child instanceof VariableDefinitionNode) {
				variableDefinitionList.add((VariableDefinitionNode) child);
			} else if(child instanceof RepeatDefinitionNode) {
				repeatDefinitionNodeList.add((RepeatDefinitionNode) child);
			} else {
				throw new RuntimeException("Unknown node: " + child);
			}
		}
		
		BlockNode[] childBlocks = childBlockList.toArray(new BlockNode[childBlockList.size()]);
		BlockPropertyNode[] blockProperties = blockPropertyList.toArray(new BlockPropertyNode[blockPropertyList.size()]);
		VariableDefinitionNode[] variableDefinitions = variableDefinitionList.toArray(new VariableDefinitionNode[variableDefinitionList.size()]);
		RepeatDefinitionNode[] repeatDefinitions = repeatDefinitionNodeList.toArray(new RepeatDefinitionNode[repeatDefinitionNodeList.size()]);
		
		HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap = new HashMap<RelayBlockPropertyType, BlockPropertyNode>();
		for(BlockPropertyNode property : blockProperties) {
			propertyMap.put(property.type, property);
		}
		
		BlockDimensions dimensions = new BlockDimensions(this.location, propertyMap);	
		
		return new BlockNode(this.location, blockName, blockType, childNodes, childBlocks, variableDefinitions, repeatDefinitions, propertyMap, dimensions);
	}

}
