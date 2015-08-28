package relay.nodes;

public class FunctionCallNode extends RelayNode {

	public FunctionCallNode(String functionName, ExpressionNode[] parameters) {
		super(RelayNodeType.FUNCTION_CALL_EXPRESSION, parameters);
	}

}
