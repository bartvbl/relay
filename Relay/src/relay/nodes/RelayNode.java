package relay.nodes;

public abstract class RelayNode {

	public final RelayNodeType type;
	public final RelayNode[] children;

	public RelayNode(RelayNodeType type, RelayNode[] children) {
		this.type = type;
		this.children = children;
	}

	public RelayNode(RelayNodeType type) {
		this.type = type;
		this.children = new RelayNode[]{};
	}
}