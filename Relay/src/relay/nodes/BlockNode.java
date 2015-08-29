package relay.nodes;

public class BlockNode extends RelayNode {
	public final String name;
	
	public final BlockNode[] childBlocks;
	public final CodeBlockNode[] childCodeBlocks;
	public final BlockPropertyNode[] blockProperties;

	public BlockNode(String blockName, RelayNode[] childNodes, BlockNode[] childBlocks, CodeBlockNode[] childCodeBlocks, BlockPropertyNode[] blockProperties) {
		super(RelayNodeType.BLOCK, childNodes);
		this.name = blockName;
		this.childBlocks = childBlocks;
		this.childCodeBlocks = childCodeBlocks;
		this.blockProperties = blockProperties;
	}
	
	@Override
	public String toString() {
		return "Block named \"" + name + "\"";
	}
}
