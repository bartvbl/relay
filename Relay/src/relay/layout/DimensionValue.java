package relay.layout;

import java.util.ArrayList;

import relay.nodes.ExpressionNode;

public class DimensionValue {
	private final ArrayList<DimensionValue> dependencies = new ArrayList<DimensionValue>();
	private final ExpressionNode expression;
	
	public final boolean isDefined;
	
	public DimensionValue(ExpressionNode expression) {
		this.expression = expression;
		this.isDefined = true;
	}
	
	public DimensionValue() {
		this.expression = null;
		this.isDefined = false;
	}

	public void addDependency(DimensionValue dependentOn) {
		this.dependencies.add(dependentOn);
	}
}
