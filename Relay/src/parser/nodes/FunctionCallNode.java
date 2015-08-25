package parser.nodes;

import parser.nodes.types.ExpressionType;
import parser.nodes.types.RelaySymbolType;

public class FunctionCallNode extends ExpressionNode {

	public final String functionName;
	public final ParameterListNode parameters;

	public FunctionCallNode(String identifyer, ParameterListNode parameters) {
		super(RelaySymbolType.EXPRESSION, ExpressionType.FUNCTION_CALL, new RelaySymbol[]{parameters});
		this.functionName = identifyer;
		this.parameters = parameters;
	}

	@Override
	public double evaluate() {
		return 0;
	}

}
