package parser.nodes;

public abstract class ExpressionNode extends RelaySymbol {

	public final ExpressionType expressionType;

	public ExpressionNode(RelaySymbolType type, ExpressionType expressionType) {
		super(type);
		this.expressionType = expressionType;
	}
	
	public ExpressionNode(RelaySymbolType type, ExpressionType expressionType, RelaySymbol[] children) {
		super(type, children);
		this.expressionType = expressionType;
	}
	
	public abstract double evaluate();

}
