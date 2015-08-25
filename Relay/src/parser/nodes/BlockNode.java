package parser.nodes;

public class BlockNode extends RelaySymbol {

	private final IdentifyerNode nameNode;

	public BlockNode(IdentifyerNode blockName, BlockContentListNode childList) {
		super(RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.nameNode = blockName;
	}

}
