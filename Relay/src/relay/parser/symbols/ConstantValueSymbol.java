package relay.parser.symbols;

import relay.nodes.RelayNode;
import relay.nodes.expressions.ConstantValueNode;
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
	public String toString() {
		return "Value node: " + value + " " + unit.value;
	}

	@Override
	public RelayNode compact() {
		return new ConstantValueNode(this.location, value, unit.value);
	}

}
