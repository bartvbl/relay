package relay.nodes;

import parser.symbols.types.ExpressionType;

public class VariableAccessNode extends ExpressionNode {

	public final String[] identifyers;

	public VariableAccessNode(String[] identifyers) {
		super(ExpressionType.VARIABLE_ACCESS);
		this.identifyers = identifyers;
	}

}
