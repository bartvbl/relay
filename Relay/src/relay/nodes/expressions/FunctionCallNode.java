package relay.nodes.expressions;

import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.RelayNodeType;
import relay.parser.LocationRange;

public class FunctionCallNode extends RelayNode {

	public final String functionIdentifyer;
	public final ExpressionNode[] parameters;

	public FunctionCallNode(LocationRange locationRange, String functionName, ExpressionNode[] parameters) {
		super(locationRange, RelayNodeType.FUNCTION_CALL_EXPRESSION, parameters);
		this.functionIdentifyer = functionName;
		this.parameters = parameters;
	}
	
	public String toString() {
		String functionString = functionIdentifyer + "(";
		boolean isNotFirstParameter = false;
		for(ExpressionNode parameter : parameters) {
			functionString += parameter;
			if(isNotFirstParameter) {
				functionString += ", ";
			}
			isNotFirstParameter = true;
		}
		functionString += ")";
		return functionString;
	}

}
