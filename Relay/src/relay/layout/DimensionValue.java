package relay.layout;

import relay.nodes.ExpressionNode;

public class DimensionValue implements MutableDependentValue {
	public final ExpressionNode expression;
	
	private double currentValue;
	
	public DimensionValue(ExpressionNode expression) {
		this.expression = expression;
	}

	public double getCurrentValue() {
		return currentValue;
	}
	
	public void updateCurrentValue() {
		expression.evaluate();
	}
	
}
