package parser.symbols;

import parser.symbols.types.ExpressionType;
import parser.symbols.types.RelaySymbolType;
import relay.nodes.AdditionExpressionNode;
import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.SubtractionExpressionNode;


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

	@Override
	public RelayNode compact() {
		ExpressionNode leftHand = (ExpressionNode) leftHandSide.compact();
		ExpressionNode rightHand = (ExpressionNode) rightHandSide.compact();
		return new SubtractionExpressionNode(leftHand, rightHand);
	}

}
