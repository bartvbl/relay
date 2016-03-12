package relay.layout;

import java.util.ArrayList;

import relay.nodes.ExpressionNode;

public class DimensionValue implements MutableDependentValue {
	public final ExpressionNode expression;
	
	private double currentValue;

	private final ArrayList<MutableDependentValue> dependencies = new ArrayList<MutableDependentValue>();
	
	public DimensionValue(ExpressionNode expression) {
		this.expression = expression;
	}

	public double getCurrentValue() {
		return currentValue;
	}
	
	public void updateCurrentValue() {
		expression.evaluate();
	}

	@Override
	public MutableDependentValue[] getDependencies() {
		return dependencies.toArray(new MutableDependentValue[dependencies.size()]);
	}

	@Override
	public void registerDependency(MutableDependentValue dependency) {
		this.dependencies.add(dependency);
	}
	
}
