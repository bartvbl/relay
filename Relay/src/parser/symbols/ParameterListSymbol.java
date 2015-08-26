package parser.symbols;

import parser.symbols.types.RelaySymbolType;

public class ParameterListSymbol extends RelaySymbol {

	public final ExpressionSymbol parameterExpression;
	public final ParameterListSymbol remainingNodes;

	public ParameterListSymbol(ExpressionSymbol expression, ParameterListSymbol remainingNodes) {
		super(RelaySymbolType.PARAMETER_LIST, new RelaySymbol[]{expression, remainingNodes});
		this.parameterExpression = expression;
		this.remainingNodes = remainingNodes;
	}

}
