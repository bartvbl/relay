package relay.nodes.expressions;

import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
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
		return (percentValue / 100d) * accessNode.evaluate();
	}
	
	public String toString() {
		return percentValue + "% of " + accessNode.toString();
	}

}
