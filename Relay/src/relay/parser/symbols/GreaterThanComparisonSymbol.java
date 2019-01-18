package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BooleanExpressionType;

public class GreaterThanComparisonSymbol extends BooleanExpressionSymbol {

	public GreaterThanComparisonSymbol(LocationRange locationRange, ExpressionSymbol leftHandSide, ExpressionSymbol rightHandSide) {
		super(locationRange, BooleanExpressionType.GREATER_THAN);
	}

	@Override
	public RelayNode compact() throws RelayException {
		// TODO Auto-generated method stub
		return null;
	}

}
