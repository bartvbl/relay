package parser.nodes;

import parser.nodes.types.ExpressionType;
import parser.nodes.types.RelaySymbolType;

public class ValueNode extends ExpressionNode {

	public final double value;
	public final UnitNode unit;

	public ValueNode(Double value, UnitNode unit) {
		super(RelaySymbolType.EXPRESSION, ExpressionType.VALUE);
		if(value == null) {
			this.value = 0;
		} else  {
			this.value = value;			
		}
		this.unit = unit;
	}

	@Override
	public double evaluate() {
		return value;
	}
	
	@Override
	public String toString() {
		return "Value node: " + value + " " + unit.value;
	}

}
