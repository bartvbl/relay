package parser.nodes;

import parser.nodes.types.ExpressionType;
import parser.nodes.types.RelaySymbolType;

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
	
	@Override
	public String toString() {
		return "Addition Expression";
	}

	@Override
	public RelaySymbol simplify() {
		return this;
	}

}
