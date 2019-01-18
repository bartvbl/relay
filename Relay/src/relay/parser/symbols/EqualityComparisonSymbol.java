package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.BooleanExpressionType;

public class EqualityComparisonSymbol extends BooleanExpressionSymbol {

	public EqualityComparisonSymbol(LocationRange locationRange, ExpressionSymbol leftHandSide, ExpressionSymbol rightHandSide) {
		super(locationRange, BooleanExpressionType.EQUALS);
	}

	@Override
	public RelayNode compact() throws RelayException {
		return new EqualityComparisonNode();
	}

}
