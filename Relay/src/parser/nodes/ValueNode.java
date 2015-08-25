package parser.nodes;

public class ValueNode extends ExpressionNode {

	public final double value;
	public final UnitNode unit;

	public ValueNode(Double value, UnitNode unit) {
		super(RelaySymbolType.EXPRESSION, ExpressionType.VALUE);
		this.value = value;
		this.unit = unit;
	}

	@Override
	public double evaluate() {
		return value;
	}

}
