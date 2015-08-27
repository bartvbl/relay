package relay.nodes;

public class RootNode extends RelayNode {
	public final BlockNode rootBlock;

	public RootNode(BlockNode rootBlock) {
		super(RelayNodeType.ROOT, new RelayNode[]{rootBlock});
		this.rootBlock = rootBlock;
	}
}
