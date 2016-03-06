package relay.nodes.expressions;

import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.RelayNodeType;

public class FunctionCallNode extends RelayNode {

	public FunctionCallNode(String functionName, ExpressionNode[] parameters) {
		super(RelayNodeType.FUNCTION_CALL_EXPRESSION, parameters);
	}

}
