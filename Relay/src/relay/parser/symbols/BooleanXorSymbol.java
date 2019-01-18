package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BooleanExpressionType;

public class BooleanXorSymbol extends BooleanExpressionSymbol {

	public BooleanXorSymbol(LocationRange locationRange, BooleanExpressionSymbol leftHandSide, BooleanExpressionSymbol rightHandSide) {
		super(locationRange, BooleanExpressionType.XOR);
	}

	@Override
	public RelayNode compact() throws RelayException {
		// TODO Auto-generated method stub
		return null;
	}

}
