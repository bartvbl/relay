package relay.parser.symbols;

import java.util.ArrayList;
import java.util.HashMap;

import relay.exceptions.RelayException;
import relay.layout.BlockDimensions;
import relay.nodes.BlockNode;
import relay.nodes.BlockPropertyNode;
import relay.nodes.CodeBlockNode;
import relay.nodes.RelayNode;
import relay.nodes.VariableDefinitionNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BlockItemType;
import relay.parser.symbols.types.RelaySymbolType;
import relay.types.RelayBlockPropertyType;
import relay.util.RelayUtil;

public class BlockSymbol extends RelaySymbol {

	public final IdentifyerSymbol nameNode;
	public final IdentifyerSymbol blockTypeNode;
	public final BlockContentListSymbol childList;

	public BlockSymbol(LocationRange locationRange, IdentifyerSymbol blockName, BlockContentListSymbol childList, IdentifyerSymbol blockType) {
		super(locationRange, RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.nameNode = blockName;
		this.blockTypeNode = blockType;
		this.childList = childList;
	}

	public BlockSymbol(LocationRange locationRange, BlockContentListSymbol childList, IdentifyerSymbol blockType) {
		super(locationRange, RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.nameNode = null;
		this.blockTypeNode = blockType;
		this.childList = childList;
	}

	@Override
	public String toString() {
		return "Block named \"" + nameNode.value + "\"";
	}

	@Override
	public RelayNode compact() throws RelayException {
		String blockName = (nameNode == null) ? "block_" + RelayUtil.generateUUID() : nameNode.value;
		ArrayList<RelayNode> children = new ArrayList<RelayNode>();
		BlockContentListSymbol currentListNode = childList;
		
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
		children.add(currentListNode.listItem.compact()); //Add the final item
		
		RelayNode[] childNodes = children.toArray(new RelayNode[children.size()]);
		
		ArrayList<BlockNode> childBlockList = new ArrayList<BlockNode>();
		ArrayList<CodeBlockNode> codeBlockList = new ArrayList<CodeBlockNode>();
		ArrayList<BlockPropertyNode> blockPropertyList = new ArrayList<BlockPropertyNode>();
		ArrayList<VariableDefinitionNode> variableDefinitionList = new ArrayList<VariableDefinitionNode>();
		
		for(RelayNode child : childNodes) {
			if(child instanceof BlockNode) {
				childBlockList.add((BlockNode) child);
			} else if(child instanceof CodeBlockNode) {
				codeBlockList.add((CodeBlockNode) child);
			} else if(child instanceof BlockPropertyNode) {
				blockPropertyList.add((BlockPropertyNode) child);
			} else if(child instanceof VariableDefinitionNode) {
				variableDefinitionList.add((VariableDefinitionNode) child);
			} else {
				throw new RuntimeException("Unknown node: " + child);
			}
		}
		
		BlockNode[] childBlocks = childBlockList.toArray(new BlockNode[childBlockList.size()]);
		CodeBlockNode[] childCodeBlocks = codeBlockList.toArray(new CodeBlockNode[codeBlockList.size()]);
		BlockPropertyNode[] blockProperties = blockPropertyList.toArray(new BlockPropertyNode[blockPropertyList.size()]);
		VariableDefinitionNode[] variableDefinitions = variableDefinitionList.toArray(new VariableDefinitionNode[variableDefinitionList.size()]);
		
		HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap = new HashMap<RelayBlockPropertyType, BlockPropertyNode>();
		for(BlockPropertyNode property : blockProperties) {
			propertyMap.put(property.type, property);
		}
		
		BlockDimensions dimensions = new BlockDimensions(this.location, propertyMap);	
		
		return new BlockNode(this.location, blockName, childNodes, childBlocks, childCodeBlocks, variableDefinitions, propertyMap, dimensions);
	}

}
