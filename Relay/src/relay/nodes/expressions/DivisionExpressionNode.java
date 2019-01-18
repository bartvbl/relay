package relay.nodes.expressions;

import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class DivisionExpressionNode extends ExpressionNode {

	public final ExpressionNode leftHandSide;
	public final ExpressionNode rightHandSide;

	public DivisionExpressionNode(LocationRange locationRange, ExpressionNode leftHand, ExpressionNode rightHand) {
		super(locationRange, ExpressionType.DIVISION, new RelayNode[]{leftHand, rightHand});
		
		this.leftHandSide = leftHand;
		this.rightHandSide = rightHand;
	}
	
	@Override
	public String toString() {
		return leftHandSide + " / " + rightHandSide;
	}

	@Override
	public double evaluate() {
		return leftHandSide.evaluate() / rightHandSide.evaluate();
	}

}
