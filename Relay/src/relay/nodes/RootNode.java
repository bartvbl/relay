package relay.nodes;

import java.awt.geom.Rectangle2D;

import lib.geom.IndexRectangle2D;
import relay.exceptions.RelayException;
import relay.layout.windowRoot.WindowDimensions;

public class RootNode extends RelayNode {
	public final BlockNode rootBlock;
	public final WindowDimensions windowDimensions;

	public RootNode(BlockNode rootBlock, IndexRectangle2D windowDimensions) throws RelayException {
		super(RelayNodeType.ROOT, new RelayNode[]{rootBlock});
		this.rootBlock = rootBlock;
		this.windowDimensions = new WindowDimensions(windowDimensions);
	}
	
	@Override
	public String toString() {
		return "Root node";
	}
}
