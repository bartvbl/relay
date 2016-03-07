package relay.nodes.expressions;

import relay.data.Unit;
import relay.nodes.ExpressionNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class ValueNode extends ExpressionNode {

	public final double value;
	public final Unit unit;

	public ValueNode(LocationRange locationRange, double value, Unit unit) {
		super(locationRange, ExpressionType.VALUE);
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
