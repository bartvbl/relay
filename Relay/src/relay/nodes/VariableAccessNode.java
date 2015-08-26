package relay.nodes;

public class VariableAccessNode extends RelayNode {

	public final String[] identifyers;

	public VariableAccessNode(String[] identifyers) {
		super(RelayNodeType.VARIABLE_ACCESS);
		this.identifyers = identifyers;
	}

}
