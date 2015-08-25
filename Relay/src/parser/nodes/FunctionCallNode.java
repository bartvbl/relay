package parser.nodes;

public class FunctionCallNode extends ExpressionNode {

	public final String functionName;
	public final ParameterListNode parameters;

	public FunctionCallNode(String identifyer, ParameterListNode parameters) {
		this.functionName = identifyer;
		this.parameters = parameters;
	}

}
