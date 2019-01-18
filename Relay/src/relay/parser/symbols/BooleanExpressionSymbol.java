package relay.parser.symbols;

import relay.parser.LocationRange;
import relay.parser.symbols.types.BooleanExpressionType;
import relay.parser.symbols.types.RelaySymbolType;

public abstract class BooleanExpressionSymbol extends RelaySymbol {

	public final BooleanExpressionType expressionType;
	
	public BooleanExpressionSymbol(LocationRange locationRange, BooleanExpressionType expressionType) {
		super(locationRange, RelaySymbolType.EXPRESSION);
		this.expressionType = expressionType;
	}
	
	public BooleanExpressionSymbol(LocationRange locationRange, BooleanExpressionType expressionType, RelaySymbol[] children) {
		super(locationRange, RelaySymbolType.EXPRESSION, children);
		this.expressionType = expressionType;
	}
	
	public BooleanExpressionSymbol(LocationRange locationRange, RelaySymbolType relaySymbolType, BooleanExpressionType expressionType, RelaySymbol[] children) {
		super(locationRange, relaySymbolType, children);
		this.expressionType = expressionType;
	}
}
