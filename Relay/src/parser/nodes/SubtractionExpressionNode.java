package parser.nodes;


public class SubtractionExpressionNode extends ExpressionNode {

	private final ExpressionNode leftHandSide;
	private final ExpressionNode rightHandSide;

	public SubtractionExpressionNode(ExpressionNode leftHandSide, ExpressionNode rightHandSide) {
		super(RelaySymbolType.EXPRESSION, ExpressionType.SUBTRACTION, new RelaySymbol[]{leftHandSide, rightHandSide});
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}

	@Override
	public double evaluate() {
		return leftHandSide.evaluate() - rightHandSide.evaluate();
	}

}
