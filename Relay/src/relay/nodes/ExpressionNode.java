package relay.nodes;

import parser.symbols.types.ExpressionType;

public class ExpressionNode extends RelayNode {
	
	public final ExpressionType expressionType;

	public ExpressionNode(ExpressionType type) {
		super(RelayNodeType.EXPRESSION);
		this.expressionType = type;
	}

	public ExpressionNode(ExpressionType type, RelayNode[] children) {
		super(RelayNodeType.EXPRESSION, children);
		this.expressionType = type;
	}

}
