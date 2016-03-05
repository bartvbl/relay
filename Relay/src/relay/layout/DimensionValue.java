package relay.layout;

import relay.nodes.ExpressionNode;

public class DimensionValue {
	public final ExpressionNode expression;
	public final boolean isDefined;
	
	private double currentValue;
	
	public DimensionValue(ExpressionNode expression) {
		this.expression = expression;
		this.isDefined = true;
	}

	public DimensionValue() {
		this.expression = null;
		this.isDefined = false;
	}
	
	public double getCurrentValue() {
		return currentValue;
	}
	
	public void updateCurrentValue() {
		expression.evaluate();
	}
	
}
