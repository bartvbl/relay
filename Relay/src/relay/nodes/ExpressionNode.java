package relay.nodes;

import relay.parser.symbols.types.ExpressionType;

public abstract class ExpressionNode extends RelayNode {
	
	public final ExpressionType expressionType;

	public ExpressionNode(ExpressionType type) {
		super(RelayNodeType.EXPRESSION);
		this.expressionType = type;
	}

	public ExpressionNode(ExpressionType type, RelayNode[] children) {
		super(RelayNodeType.EXPRESSION, children);
		this.expressionType = type;
	}
	
	public abstract double evaluate();

}
