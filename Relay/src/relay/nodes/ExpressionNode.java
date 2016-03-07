package relay.nodes;

import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public abstract class ExpressionNode extends RelayNode {
	
	public final ExpressionType expressionType;
	public final ExpressionNode[] expressionChildren;

	public ExpressionNode(LocationRange locationRange, ExpressionType type) {
		super(locationRange, RelayNodeType.EXPRESSION);
		this.expressionType = type;
		this.expressionChildren = new ExpressionNode[0];
	}

	public ExpressionNode(LocationRange locationRange, ExpressionType type, RelayNode[] children) {
		super(locationRange, RelayNodeType.EXPRESSION, children);
		this.expressionType = type;
		this.expressionChildren = new ExpressionNode[children.length];
		
		for(int i = 0; i < children.length; i++) {
			expressionChildren[i] = (ExpressionNode) children[i];
		}
	}
	
	public abstract double evaluate();

}
