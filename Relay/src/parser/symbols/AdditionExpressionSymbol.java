package parser.symbols;

import parser.symbols.types.ExpressionType;
import parser.symbols.types.RelaySymbolType;
import relay.nodes.AdditionExpressionNode;
import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;

public class AdditionExpressionSymbol extends ExpressionSymbol {

	private final ExpressionSymbol leftHandSide;
	private final ExpressionSymbol rightHandSide;

	public AdditionExpressionSymbol(ExpressionSymbol leftHandSide, ExpressionSymbol rightHandSide) {
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
	public RelayNode compact() {
		ExpressionNode leftHand = (ExpressionNode) leftHandSide.compact();
		ExpressionNode rightHand = (ExpressionNode) rightHandSide.compact();
		return new AdditionExpressionNode(leftHand, rightHand);
	}

}
