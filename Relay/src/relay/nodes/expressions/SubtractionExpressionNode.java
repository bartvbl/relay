package relay.nodes.expressions;

import relay.nodes.ExpressionNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class SubtractionExpressionNode extends ExpressionNode {

	public final ExpressionNode leftHandSide;
	public final ExpressionNode rightHandSide;

	public SubtractionExpressionNode(LocationRange locationRange, ExpressionNode leftHand, ExpressionNode rightHand) {
		super(locationRange, ExpressionType.SUBTRACTION, new ExpressionNode[]{leftHand, rightHand});
		
		this.leftHandSide = leftHand;
		this.rightHandSide = rightHand;
	}

	@Override
	public String toString() {
		return "Subtraction expression";
	}

	@Override
	public double evaluate() {
		return leftHandSide.evaluate() - rightHandSide.evaluate();
	}
}
