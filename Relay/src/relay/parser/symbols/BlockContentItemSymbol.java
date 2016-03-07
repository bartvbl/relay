package relay.parser.symbols;

import java_cup.runtime.ComplexSymbolFactory.Location;
import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BlockItemType;
import relay.parser.symbols.types.RelaySymbolType;

public class BlockContentItemSymbol extends RelaySymbol {
	public final BlockItemType itemType;
	
	public final BlockSymbol blockNode;
	public final BlockPropertySymbol propertyNode;
	public final CodeBlockSymbol codeBlockNode;
	public final VariableDefinitionSymbol variableDefinitionNode;

	public BlockContentItemSymbol(LocationRange locationRange, BlockSymbol item) {
		super(locationRange, RelaySymbolType.BLOCK_CONTENT_ITEM, new RelaySymbol[]{item});
		this.blockNode = item;
		this.propertyNode = null;
		this.codeBlockNode = null;
		this.variableDefinitionNode = null;
		this.itemType = BlockItemType.BLOCK;
	}

	public BlockContentItemSymbol(LocationRange locationRange, BlockPropertySymbol item) {
		super(locationRange, RelaySymbolType.BLOCK_CONTENT_ITEM, new RelaySymbol[]{item});
		this.blockNode = null;
		this.propertyNode = item;
		this.codeBlockNode = null;
		this.variableDefinitionNode = null;
		this.itemType = BlockItemType.PROPERTY;
	}

	public BlockContentItemSymbol(LocationRange locationRange, CodeBlockSymbol item) {
		super(locationRange, RelaySymbolType.BLOCK_CONTENT_ITEM, new RelaySymbol[]{item});
		this.blockNode = null;
		this.propertyNode = null;
		this.codeBlockNode = item;
		this.variableDefinitionNode = null;
		this.itemType = BlockItemType.CODE_BLOCK;
	}
	
	public BlockContentItemSymbol(LocationRange locationRange) {
		super(locationRange, RelaySymbolType.BLOCK_CONTENT_ITEM);
		this.blockNode = null;
		this.propertyNode = null;
		this.codeBlockNode = null;
		this.variableDefinitionNode = null;
		this.itemType = BlockItemType.EMPTY;
	}
	
	public BlockContentItemSymbol(LocationRange locationRange, VariableDefinitionSymbol item) {
		super(locationRange, RelaySymbolType.BLOCK_CONTENT_ITEM, new RelaySymbol[]{item});
		this.blockNode = null;
		this.propertyNode = null;
		this.codeBlockNode = null;
		this.variableDefinitionNode = item;
		this.itemType = BlockItemType.VARIABLE_DEFINITION;
	}

	@Override
	public String toString() {
		return "Block content item of type: " + itemType;
	}

	@Override
	public RelayNode compact() throws RelayException {
		switch(itemType) {
		case BLOCK:
			return blockNode.compact();
		case CODE_BLOCK:
			return codeBlockNode.compact();
		case EMPTY:
			throw new RuntimeException("An empty node can not be compacted!");
		case PROPERTY:
			return propertyNode.compact();
		case VARIABLE_DEFINITION:
			return variableDefinitionNode.compact();
		default:
			throw new RuntimeException("Forgot to implement another type!");
		}
	}

}
