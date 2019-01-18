package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.expressions.AdditionExpressionNode;
import relay.nodes.expressions.MultiplicationExpressionNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class MultiplicationExpressionSymbol extends ExpressionSymbol {

	private final ExpressionSymbol leftHandSide;
	private final ExpressionSymbol rightHandSide;

	public MultiplicationExpressionSymbol(LocationRange locationRange, ExpressionSymbol leftHandSide, ExpressionSymbol rightHandSide) {
		super(locationRange, ExpressionType.MULTIPLICATION, new RelaySymbol[]{leftHandSide, rightHandSide});
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}
	
	@Override
	public String toString() {
		return "Multiplication Expression";
	}

	@Override
	public RelayNode compact() throws RelayException {
		ExpressionNode leftHand = (ExpressionNode) leftHandSide.compact();
		ExpressionNode rightHand = (ExpressionNode) rightHandSide.compact();
		return new MultiplicationExpressionNode(new LocationRange(leftHandSide.location.start, rightHandSide.location.end), leftHand, rightHand);
	}

}
