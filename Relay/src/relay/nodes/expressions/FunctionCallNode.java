package relay.nodes.expressions;

import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.RelayNodeType;
import relay.parser.LocationRange;

public class FunctionCallNode extends RelayNode {

	public FunctionCallNode(LocationRange locationRange, String functionName, ExpressionNode[] parameters) {
		super(locationRange, RelayNodeType.FUNCTION_CALL_EXPRESSION, parameters);
	}

}
