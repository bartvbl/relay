package relay.layout;

import lib.geom.Rectangle2D;

public class RelayDimensionNode {
	public final Rectangle2D size;
	public final RelayDimensionNode[] children;
	
	public RelayDimensionNode(Rectangle2D size, RelayDimensionNode[] children) {
		this.size = size;
		this.children = children;
	}
}
