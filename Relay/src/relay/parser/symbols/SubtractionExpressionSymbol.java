package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.AdditionExpressionNode;
import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.SubtractionExpressionNode;
import relay.parser.symbols.types.ExpressionType;
import relay.parser.symbols.types.RelaySymbolType;


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
	public RelayNode compact() throws RelayException {
		ExpressionNode leftHand = (ExpressionNode) leftHandSide.compact();
		ExpressionNode rightHand = (ExpressionNode) rightHandSide.compact();
		return new SubtractionExpressionNode(leftHand, rightHand);
	}

}
