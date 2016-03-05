package relay.nodes;

import relay.exceptions.RelayException;
import relay.layout.WindowDimensions;

public class RootNode extends RelayNode {
	public final BlockNode rootBlock;
	public final WindowDimensions windowDimensions;

	public RootNode(BlockNode rootBlock) throws RelayException {
		super(RelayNodeType.ROOT, new RelayNode[]{rootBlock});
		this.rootBlock = rootBlock;
		this.windowDimensions = new WindowDimensions();
	}
	
	@Override
	public String toString() {
		return "Root node";
	}
}
