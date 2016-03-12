package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class BracketExpressionSymbol extends ExpressionSymbol {

	private final ExpressionSymbol expression;

	public BracketExpressionSymbol(LocationRange locationRange, ExpressionSymbol expression) {
		super(locationRange, ExpressionType.BRACKET, new RelaySymbol[]{expression});
		this.expression = expression;
	}

	@Override
	public RelayNode compact() throws RelayException {
		return expression.compact();
	}

}
