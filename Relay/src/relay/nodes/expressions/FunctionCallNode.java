package relay.nodes.expressions;

import java.util.Arrays;

import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.RelayNodeType;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;
import relay.types.FunctionType;

public class FunctionCallNode extends ExpressionNode {

	public final FunctionType functionType;
	public final ExpressionNode[] parameters;

	public FunctionCallNode(LocationRange locationRange, FunctionType functionType, ExpressionNode[] parameters) {
		super(locationRange, ExpressionType.FUNCTION_CALL, parameters);
		this.functionType = functionType;
		this.parameters = parameters;
	}
	
	public String toString() {
		String functionString = functionType + "(";
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

	@Override
	public double evaluate() {
		double[] parameterValues = new double[parameters.length];
		for(int i = 0; i < parameters.length; i++) {
			parameterValues[i] = parameters[i].evaluate();
		}
		
		switch(functionType) {
		case max:
			double max = parameterValues[0];
			for(double value : parameterValues) {
				max = Math.max(max, value);
			}
			return max;
		case min:
			double min = parameterValues[0];
			for(double value : parameterValues) {
				min = Math.min(min, value);
			}
			return min;
		default:
			throw new RuntimeException("Unsupported function type: " + functionType + ". Did you forget to implement it?");
		}
	}

}
