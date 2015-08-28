package relay.nodes;

public class BlockNode extends RelayNode {
	public final String name;

	public BlockNode(String blockName, RelayNode[] childNodes) {
		super(RelayNodeType.BLOCK, childNodes);
		this.name = blockName;
	}
}
