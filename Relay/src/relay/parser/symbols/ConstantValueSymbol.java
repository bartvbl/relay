package relay.parser.symbols;

import relay.nodes.RelayNode;
import relay.nodes.expressions.ValueNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class ConstantValueSymbol extends ExpressionSymbol {

	public final double value;
	public final UnitSymbol unit;

	public ConstantValueSymbol(LocationRange locationRange, Double value, UnitSymbol unit) {
		super(locationRange, ExpressionType.CONSTANT_VALUE);
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

	@Override
	public RelayNode compact() {
		return new ValueNode(this.location, value, unit.value);
	}

}
