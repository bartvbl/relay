package relay.nodes;

import lib.geom.IndexRectangle2D;
import relay.exceptions.RelayException;
import relay.layout.windowRoot.WindowDimensions;
import relay.parser.LocationRange;

public class RootNode extends RelayNode {
	public final BlockNode rootBlock;
	public final WindowDimensions windowDimensions;

	public RootNode(LocationRange locationRange, BlockNode rootBlock, IndexRectangle2D windowDimensions) throws RelayException {
		super(locationRange, RelayNodeType.ROOT, new RelayNode[]{rootBlock});
		this.rootBlock = rootBlock;
		this.windowDimensions = new WindowDimensions(windowDimensions);
	}
	
	@Override
	public String toString() {
		return "Root node";
	}
}
