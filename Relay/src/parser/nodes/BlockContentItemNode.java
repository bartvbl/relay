package parser.nodes;

public class BlockContentItemNode extends RelaySymbol {
	public final BlockItemType type;
	
	public final BlockNode blockNode;
	public final BlockPropertyNode propertyNode;
	public final CodeBlockNode codeBlockNode;

	public BlockContentItemNode(BlockNode item) {
		super(RelaySymbolType.BLOCK_CONTENT_ITEM, new RelaySymbol[]{item});
		this.blockNode = item;
		this.propertyNode = null;
		this.codeBlockNode = null;
		this.type = BlockItemType.BLOCK;
	}

	public BlockContentItemNode(BlockPropertyNode item) {
		super(RelaySymbolType.BLOCK_CONTENT_ITEM, new RelaySymbol[]{item});
		this.blockNode = null;
		this.propertyNode = item;
		this.codeBlockNode = null;
		this.type = BlockItemType.PROPERTY;
	}

	public BlockContentItemNode(CodeBlockNode item) {
		super(RelaySymbolType.BLOCK_CONTENT_ITEM, new RelaySymbol[]{item});
		this.blockNode = null;
		this.propertyNode = null;
		this.codeBlockNode = item;
		this.type = BlockItemType.CODE_BLOCK;
	}
	
	public BlockContentItemNode() {
		super(RelaySymbolType.BLOCK_CONTENT_ITEM);
		this.blockNode = null;
		this.propertyNode = null;
		this.codeBlockNode = null;
		this.type = BlockItemType.EMPTY;
	}

}
