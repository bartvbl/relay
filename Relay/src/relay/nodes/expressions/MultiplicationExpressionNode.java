package relay.nodes.expressions;

import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class MultiplicationExpressionNode extends ExpressionNode {

	public final ExpressionNode leftHandSide;
	public final ExpressionNode rightHandSide;

	public MultiplicationExpressionNode(LocationRange locationRange, ExpressionNode leftHand, ExpressionNode rightHand) {
		super(locationRange, ExpressionType.MULTIPLICATION, new RelayNode[]{leftHand, rightHand});
		
		this.leftHandSide = leftHand;
		this.rightHandSide = rightHand;
	}
	
	@Override
	public String toString() {
		return leftHandSide + " * " + rightHandSide;
	}

	@Override
	public double evaluate() {
		return leftHandSide.evaluate() * rightHandSide.evaluate();
	}

}
