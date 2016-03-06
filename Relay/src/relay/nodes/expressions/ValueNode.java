package relay.nodes.expressions;

import relay.data.Unit;
import relay.nodes.ExpressionNode;
import relay.parser.symbols.types.ExpressionType;

public class ValueNode extends ExpressionNode {

	public final double value;
	public final Unit unit;

	public ValueNode(double value, Unit unit) {
		super(ExpressionType.VALUE);
		this.value = value;
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return "Value node: " + value + " " + unit;
	}

	@Override
	public double evaluate() {
		return value;
	}

}
