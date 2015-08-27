package parser.symbols;

import parser.symbols.types.RelaySymbolType;
import relay.nodes.RelayNode;

public class ParameterListSymbol extends RelaySymbol {

	public final ExpressionSymbol parameterExpression;
	public final ParameterListSymbol remainingNodes;
	public final boolean hasRemainingNodes;

	public ParameterListSymbol(ExpressionSymbol expression, ParameterListSymbol remainingNodes) {
		super(RelaySymbolType.PARAMETER_LIST, new RelaySymbol[]{expression, remainingNodes});
		this.parameterExpression = expression;
		this.remainingNodes = remainingNodes;
		this.hasRemainingNodes = remainingNodes != null;
	}

	@Override
	public RelayNode compact() {
		throw new RuntimeException("Lists should not propagate into the final tree structure.");
	}

}
