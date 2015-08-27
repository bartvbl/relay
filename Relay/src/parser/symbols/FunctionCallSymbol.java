package parser.symbols;

import java.util.ArrayList;

import parser.symbols.types.ExpressionType;
import parser.symbols.types.RelaySymbolType;
import relay.nodes.ExpressionNode;
import relay.nodes.FunctionCallNode;
import relay.nodes.RelayNode;

public class FunctionCallSymbol extends ExpressionSymbol {

	public final String functionName;
	public final ParameterListSymbol parameters;

	public FunctionCallSymbol(String identifyer, ParameterListSymbol parameters) {
		super(RelaySymbolType.EXPRESSION, ExpressionType.FUNCTION_CALL, new RelaySymbol[]{parameters});
		this.functionName = identifyer;
		this.parameters = parameters;
	}

	@Override
	public double evaluate() {
		return 0;
	}

	@Override
	public RelayNode compact() {
		ArrayList<ExpressionNode> functionParameters = new ArrayList<ExpressionNode>();
		ParameterListSymbol currentParameterList = parameters;
		
		do {
			functionParameters.add((ExpressionNode)currentParameterList.parameterExpression.compact());
			currentParameterList = currentParameterList.remainingNodes;
		} while (currentParameterList.hasRemainingNodes);
		
		ExpressionNode[] allParameters = functionParameters.toArray(new ExpressionNode[functionParameters.size()]);
		return new FunctionCallNode(functionName, allParameters);
	}

}
