package parser.nodes;

import parser.nodes.types.ExpressionType;
import parser.nodes.types.RelaySymbolType;


public class SubtractionExpressionSymbol extends ExpressionSymbol {

	private final ExpressionSymbol leftHandSide;
	private final ExpressionSymbol rightHandSide;

	public SubtractionExpressionSymbol(ExpressionSymbol leftHandSide, ExpressionSymbol rightHandSide) {
		super(RelaySymbolType.EXPRESSION, ExpressionType.SUBTRACTION, new RelaySymbol[]{leftHandSide, rightHandSide});
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}

	@Override
	public double evaluate() {
		return leftHandSide.evaluate() - rightHandSide.evaluate();
	}

}
