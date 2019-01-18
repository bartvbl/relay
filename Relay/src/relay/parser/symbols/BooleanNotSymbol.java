package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BooleanExpressionType;

public class BooleanNotSymbol extends BooleanExpressionSymbol {

	public BooleanNotSymbol(LocationRange locationRange, BooleanExpressionSymbol expression) {
		super(locationRange, BooleanExpressionType.NOT);
	}

	@Override
	public RelayNode compact() throws RelayException {
		// TODO Auto-generated method stub
		return null;
	}

}
