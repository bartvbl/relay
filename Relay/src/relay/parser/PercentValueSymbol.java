package relay.parser;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.symbols.ExpressionSymbol;
import relay.parser.symbols.RelaySymbol;
import relay.parser.symbols.VariableAccessSymbol;
import relay.parser.symbols.types.ExpressionType;

public class PercentValueSymbol extends ExpressionSymbol {

	public PercentValueSymbol(LocationRange locationRange, Double value, VariableAccessSymbol property) {
		super(locationRange, ExpressionType.PERCENTAGE_VALUE, new RelaySymbol[]{property});
	}

	@Override
	public double evaluate() {
		return 0;
	}

	@Override
	public RelayNode compact() throws RelayException {
		return null;
	}

}
