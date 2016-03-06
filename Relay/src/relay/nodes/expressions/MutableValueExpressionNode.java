package relay.nodes.expressions;

import relay.data.Unit;
import relay.nodes.ExpressionNode;
import relay.parser.symbols.types.ExpressionType;

public class MutableValueExpressionNode extends ExpressionNode {

	public double value;
	public final Unit unit;

	public MutableValueExpressionNode(double value, Unit unit) {
		super(ExpressionType.VALUE);
		this.value = value;
		this.unit = unit;
	}
	
	public void set(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Mutable window value node: " + value + " " + unit;
	}

	@Override
	public double evaluate() {
		return value;
	}

}
