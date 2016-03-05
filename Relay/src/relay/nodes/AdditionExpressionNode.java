package relay.nodes;

import relay.parser.symbols.types.ExpressionType;

public class AdditionExpressionNode extends ExpressionNode {

	public final ExpressionNode leftHandSide;
	public final ExpressionNode rightHandSide;

	public AdditionExpressionNode(ExpressionNode leftHand, ExpressionNode rightHand) {
		super(ExpressionType.ADDITION, new RelayNode[]{leftHand, rightHand});
		
		this.leftHandSide = leftHand;
		this.rightHandSide = rightHand;
	}
	
	@Override
	public String toString() {
		return "Addition expression";
	}

	@Override
	public double evaluate() {
		return leftHandSide.evaluate() + rightHandSide.evaluate();
	}

}
