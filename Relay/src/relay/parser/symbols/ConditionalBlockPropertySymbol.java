package relay.parser.symbols;

import relay.parser.LocationRange;

public class ConditionalBlockPropertySymbol extends BlockPropertySymbol {

	public ConditionalBlockPropertySymbol(LocationRange locationRange, IdentifyerSymbol identifyer, ExpressionSymbol expression) {
		super(locationRange, identifyer, expression);
	}

	public ConditionalBlockPropertySymbol(LocationRange locationRange, IdentifyerSymbol identifyer, BooleanExpressionSymbol conditionExpression, ExpressionSymbol expression) {
		super(locationRange, identifyer, expression);
	}

}
