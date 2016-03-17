package relay.parser.symbols;

import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.RelaySymbolType;

public class ParameterListSymbol extends RelaySymbol {

	public final ExpressionSymbol parameterExpression;
	public final ParameterListSymbol remainingNodes;
	public final boolean hasRemainingNodes;

	public ParameterListSymbol(LocationRange locationRange, ExpressionSymbol expression, ParameterListSymbol remainingNodes) {
		super(locationRange, RelaySymbolType.PARAMETER_LIST, new RelaySymbol[]{expression, remainingNodes});
		this.parameterExpression = expression;
		this.remainingNodes = remainingNodes;
		this.hasRemainingNodes = remainingNodes != null;
	}

	public ParameterListSymbol(LocationRange locationRange, ExpressionSymbol expression) {
		super(locationRange, RelaySymbolType.PARAMETER_LIST, new RelaySymbol[]{expression});
		this.parameterExpression = expression;
		this.remainingNodes = null;
		this.hasRemainingNodes = false;
	}

	@Override
	public RelayNode compact() {
		throw new RuntimeException("Lists should not propagate into the final tree structure.");
	}

}
