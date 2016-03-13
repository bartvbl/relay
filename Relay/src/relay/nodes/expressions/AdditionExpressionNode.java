package relay.nodes.expressions;

import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class AdditionExpressionNode extends ExpressionNode {

	public final ExpressionNode leftHandSide;
	public final ExpressionNode rightHandSide;

	public AdditionExpressionNode(LocationRange locationRange, ExpressionNode leftHand, ExpressionNode rightHand) {
		super(locationRange, ExpressionType.ADDITION, new RelayNode[]{leftHand, rightHand});
		
		this.leftHandSide = leftHand;
		this.rightHandSide = rightHand;
	}
	
	@Override
	public String toString() {
		return leftHandSide + " + " + rightHandSide;
	}

	@Override
	public double evaluate() {
		return leftHandSide.evaluate() + rightHandSide.evaluate();
	}

}
