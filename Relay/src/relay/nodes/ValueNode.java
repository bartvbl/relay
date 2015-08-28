package relay.nodes;

import parser.symbols.types.ExpressionType;
import relay.data.Unit;

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

}
