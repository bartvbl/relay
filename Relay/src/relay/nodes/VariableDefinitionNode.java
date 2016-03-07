package relay.nodes;

import relay.parser.LocationRange;

public class VariableDefinitionNode extends RelayNode {

	public final String identifier;
	public final ExpressionNode expression;

	public VariableDefinitionNode(LocationRange locationRange, String identifier, ExpressionNode expressionNode) {
		super(locationRange, RelayNodeType.VARIABLE_DEFINITION, new RelayNode[]{expressionNode});
		this.identifier = identifier;
		this.expression = expressionNode;
	}

}
