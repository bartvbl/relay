package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BooleanExpressionType;

public class BooleanAndSymbol extends BooleanExpressionSymbol {

	public BooleanAndSymbol(LocationRange locationRange, BooleanExpressionSymbol leftHandSide, BooleanExpressionSymbol rightHandSide) {
		super(locationRange, BooleanExpressionType.AND);
	}

	@Override
	public RelayNode compact() throws RelayException {
		// TODO Auto-generated method stub
		return null;
	}

}
