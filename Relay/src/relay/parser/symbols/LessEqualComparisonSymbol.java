package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BooleanExpressionType;

public class LessEqualComparisonSymbol extends BooleanExpressionSymbol {

	public LessEqualComparisonSymbol(LocationRange locationRange, ExpressionSymbol leftHandSide, ExpressionSymbol rightHandSide) {
		super(locationRange, BooleanExpressionType.LESS_OR_EQUAL);
	}

	@Override
	public RelayNode compact() throws RelayException {
		// TODO Auto-generated method stub
		return null;
	}

}
