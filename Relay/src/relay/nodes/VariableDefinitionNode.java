package relay.nodes;

import relay.layout.MutableDependentValue;
import relay.parser.LocationRange;

public class VariableDefinitionNode extends RelayNode implements MutableDependentValue {

	public final String identifier;
	public final ExpressionNode expression;
	private double value = 0;

	public VariableDefinitionNode(LocationRange locationRange, String identifier, ExpressionNode expressionNode) {
		super(locationRange, RelayNodeType.VARIABLE_DEFINITION, new RelayNode[]{expressionNode});
		this.identifier = identifier;
		this.expression = expressionNode;
	}

	@Override
	public void updateCurrentValue() {
		value = expression.evaluate();
	}

	@Override
	public double getCurrentValue() {
		return value;
	}

}
