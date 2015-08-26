package relay.nodes;

import parser.symbols.types.ExpressionType;

public class AdditionExpressionNode extends ExpressionNode {

	public final ExpressionNode leftHandSide;
	public final ExpressionNode rightHandSide;

	public AdditionExpressionNode(ExpressionNode leftHand, ExpressionNode rightHand) {
		super(ExpressionType.ADDITION);
		
		this.leftHandSide = leftHand;
		this.rightHandSide = rightHand;
	}

}
