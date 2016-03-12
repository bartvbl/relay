package relay.parser.symbols;

import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;
import relay.parser.symbols.types.RelaySymbolType;

public abstract class ExpressionSymbol extends RelaySymbol {

	public final ExpressionType expressionType;

	public ExpressionSymbol(LocationRange locationRange, ExpressionType expressionType) {
		super(locationRange, RelaySymbolType.EXPRESSION);
		this.expressionType = expressionType;
	}
	
	public ExpressionSymbol(LocationRange locationRange, ExpressionType expressionType, RelaySymbol[] children) {
		super(locationRange, RelaySymbolType.EXPRESSION, children);
		this.expressionType = expressionType;
	}
	
	public ExpressionSymbol(LocationRange locationRange, RelaySymbolType relaySymbolType, ExpressionType expressionType, RelaySymbol[] children) {
		super(locationRange, relaySymbolType, children);
		this.expressionType = expressionType;
	}
}
