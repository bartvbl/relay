package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BooleanExpressionType;

public class LessThanComparisonSymbol extends BooleanExpressionSymbol {

	public LessThanComparisonSymbol(LocationRange locationRange, ExpressionSymbol leftHandSide, ExpressionSymbol rightHandSide) {
		super(locationRange, BooleanExpressionType.LESS_THAN);
	}

	@Override
	public RelayNode compact() throws RelayException {
		// TODO Auto-generated method stub
		return null;
	}

}
