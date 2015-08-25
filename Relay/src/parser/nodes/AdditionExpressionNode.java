package parser.nodes;

public class AdditionExpressionNode extends ExpressionNode {

	private final ExpressionNode leftHandSide;
	private final ExpressionNode rightHandSide;

	public AdditionExpressionNode(ExpressionNode leftHandSide, ExpressionNode rightHandSide) {
		super(RelaySymbolType.EXPRESSION, ExpressionType.ADDITION, new RelaySymbol[]{leftHandSide, rightHandSide});
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}

	@Override
	public double evaluate() {
		return leftHandSide.evaluate() + rightHandSide.evaluate();
	}

}