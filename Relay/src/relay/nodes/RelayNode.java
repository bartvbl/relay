package relay.nodes;

import relay.parser.LocationRange;

public abstract class RelayNode {

	public final RelayNodeType type;
	public final RelayNode[] children;
	public final LocationRange location;

	public RelayNode(LocationRange locationRange, RelayNodeType type, RelayNode[] children) {
		this.type = type;
		this.location = locationRange;
		this.children = children;
	}

	public RelayNode(LocationRange locationRange, RelayNodeType type) {
		this.type = type;
		this.location = locationRange;
		this.children = new RelayNode[]{};
	}
}