package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.expressions.AdditionExpressionNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;
import relay.parser.symbols.types.RelaySymbolType;

public class AdditionExpressionSymbol extends ExpressionSymbol {

	private final ExpressionSymbol leftHandSide;
	private final ExpressionSymbol rightHandSide;

	public AdditionExpressionSymbol(LocationRange locationRange, ExpressionSymbol leftHandSide, ExpressionSymbol rightHandSide) {
		super(locationRange, ExpressionType.ADDITION, new RelaySymbol[]{leftHandSide, rightHandSide});
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
	public RelayNode compact() throws RelayException {
		ExpressionNode leftHand = (ExpressionNode) leftHandSide.compact();
		ExpressionNode rightHand = (ExpressionNode) rightHandSide.compact();
		return new AdditionExpressionNode(leftHand, rightHand);
	}

}
