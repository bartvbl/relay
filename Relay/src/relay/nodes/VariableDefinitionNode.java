package relay.nodes;

import java.util.ArrayList;

import relay.layout.MutableDependentValue;
import relay.parser.LocationRange;

public class VariableDefinitionNode extends RelayNode implements MutableDependentValue {

	public final String identifier;
	public final ExpressionNode expression;
	private double value = 0;
	private final ArrayList<MutableDependentValue> dependencies = new ArrayList<MutableDependentValue>();

	public VariableDefinitionNode(LocationRange locationRange, String identifier, ExpressionNode expressionNode) {
		super(locationRange, RelayNodeType.VARIABLE_DEFINITION, new RelayNode[]{expressionNode});
		this.identifier = identifier;
		this.expression = expressionNode;
	}

	@Override
	public void updateCurrentValue() {
		value = expression.evaluate();
	}

	@Override
	public double getCurrentValue() {
		return value;
	}

	public MutableDependentValue[] getDependencies() {
		return dependencies.toArray(new MutableDependentValue[dependencies.size()]);
	}

	public void registerDependency(MutableDependentValue dependency) {
		this.dependencies.add(dependency);
	}
}
