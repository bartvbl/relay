package parser.symbols;

import parser.symbols.types.ExpressionType;
import parser.symbols.types.RelaySymbolType;

public class ValueSymbol extends ExpressionSymbol {

	public final double value;
	public final UnitSymbol unit;

	public ValueSymbol(Double value, UnitSymbol unit) {
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
