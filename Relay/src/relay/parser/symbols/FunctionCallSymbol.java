package relay.parser.symbols;

import java.util.ArrayList;

import relay.exceptions.RelayException;
import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.expressions.FunctionCallNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;
import relay.parser.symbols.types.RelaySymbolType;
import relay.types.FunctionType;

public class FunctionCallSymbol extends ExpressionSymbol {

	public final String functionName;
	public final ParameterListSymbol parameters;

	public FunctionCallSymbol(LocationRange locationRange, String identifyer, ParameterListSymbol parameters) {
		super(locationRange, ExpressionType.FUNCTION_CALL, new RelaySymbol[]{parameters});
		this.functionName = identifyer;
		this.parameters = parameters;
	}

	@Override
	public RelayNode compact() throws RelayException {
		ArrayList<ExpressionNode> functionParameters = new ArrayList<ExpressionNode>();
		ParameterListSymbol currentParameterList = parameters;
		
		if(currentParameterList != null) {
			functionParameters.add((ExpressionNode)currentParameterList.parameterExpression.compact());
			
			while (currentParameterList.hasRemainingNodes) {
				currentParameterList = currentParameterList.remainingNodes;
				functionParameters.add((ExpressionNode)currentParameterList.parameterExpression.compact());
			} 
		}
		
		ExpressionNode[] allParameters = functionParameters.toArray(new ExpressionNode[functionParameters.size()]);
		
		FunctionType functionType;
		try {			
			functionType = FunctionType.valueOf(functionName);
		} catch(Exception e) {
			throw new RelayException("Unknown function type \"" + functionName +  "\".", location);
		}
		
		return new FunctionCallNode(this.location, functionType, allParameters);
	}

}
