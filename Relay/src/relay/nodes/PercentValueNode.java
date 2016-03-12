package relay.nodes;

import relay.nodes.expressions.VariableAccessNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class PercentValueNode extends ExpressionNode {

	private double percentValue;
	private VariableAccessNode accessNode;

	public PercentValueNode(LocationRange location, double value, VariableAccessNode accessNode) {
		super(location, ExpressionType.PERCENTAGE_VALUE, new RelayNode[]{accessNode});
		this.percentValue = value;
		this.accessNode = accessNode;
	}

	@Override
	public double evaluate() {
		return percentValue * accessNode.evaluate();
	}

}