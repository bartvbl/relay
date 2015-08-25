package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class ParameterListNode extends RelaySymbol {

	public final ExpressionNode parameterExpression;
	public final ParameterListNode remainingNodes;

	public ParameterListNode(ExpressionNode expression, ParameterListNode remainingNodes) {
		super(RelaySymbolType.PARAMETER_LIST, new RelaySymbol[]{expression, remainingNodes});
		this.parameterExpression = expression;
		this.remainingNodes = remainingNodes;
	}

}
