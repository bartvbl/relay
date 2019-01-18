package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BooleanExpressionType;

public class BooleanOrSymbol extends BooleanExpressionSymbol {

	public BooleanOrSymbol(LocationRange locationRange, BooleanExpressionSymbol leftHandSide, BooleanExpressionSymbol rightHandSide) {
		super(locationRange, BooleanExpressionType.OR);
	}

	@Override
	public RelayNode compact() throws RelayException {
		// TODO Auto-generated method stub
		return null;
	}

}
