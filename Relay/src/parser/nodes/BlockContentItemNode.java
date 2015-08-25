package parser.nodes;

import parser.nodes.types.BlockItemType;
import parser.nodes.types.RelaySymbolType;

public class BlockContentItemNode extends RelaySymbol {
	public final BlockItemType itemType;
	
	public final BlockNode blockNode;
	public final BlockPropertyNode propertyNode;
	public final CodeBlockNode codeBlockNode;

	public BlockContentItemNode(BlockNode item) {
		super(RelaySymbolType.BLOCK_CONTENT_ITEM, new RelaySymbol[]{item});
		this.blockNode = item;
		this.propertyNode = null;
		this.codeBlockNode = null;
		this.itemType = BlockItemType.BLOCK;
	}

	public BlockContentItemNode(BlockPropertyNode item) {
		super(RelaySymbolType.BLOCK_CONTENT_ITEM, new RelaySymbol[]{item});
		this.blockNode = null;
		this.propertyNode = item;
		this.codeBlockNode = null;
		this.itemType = BlockItemType.PROPERTY;
	}

	public BlockContentItemNode(CodeBlockNode item) {
		super(RelaySymbolType.BLOCK_CONTENT_ITEM, new RelaySymbol[]{item});
		this.blockNode = null;
		this.propertyNode = null;
		this.codeBlockNode = item;
		this.itemType = BlockItemType.CODE_BLOCK;
	}
	
	public BlockContentItemNode() {
		super(RelaySymbolType.BLOCK_CONTENT_ITEM);
		this.blockNode = null;
		this.propertyNode = null;
		this.codeBlockNode = null;
		this.itemType = BlockItemType.EMPTY;
	}
	
	@Override
	public String toString() {
		return "Block content item of type: " + itemType;
	}

	@Override
	public RelaySymbol simplify() {
		return this;
	}

}
