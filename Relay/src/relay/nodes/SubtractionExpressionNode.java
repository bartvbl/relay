package relay.nodes;

import parser.symbols.types.ExpressionType;

public class SubtractionExpressionNode extends ExpressionNode {

	public final ExpressionNode leftHandSide;
	public final ExpressionNode rightHandSide;

	public SubtractionExpressionNode(ExpressionNode leftHand, ExpressionNode rightHand) {
		super(ExpressionType.SUBTRACTION);
		
		this.leftHandSide = leftHand;
		this.rightHandSide = rightHand;
	}

	@Override
	public String toString() {
		return "Subtraction expression";
	}
}
