package relay.nodes.expressions;

import java.util.Arrays;

import relay.exceptions.RelayRuntimeException;
import relay.layout.MutableDependentValue;
import relay.nodes.ExpressionNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class VariableAccessNode extends ExpressionNode {

	public final String[] identifyers;
	private MutableDependentValue dependency = null;

	public VariableAccessNode(LocationRange locationRange, String[] identifyers) {
		super(locationRange, ExpressionType.VARIABLE_ACCESS);
		this.identifyers = identifyers;
	}
	
	@Override
	public String toString() {
		String totalAccessString = identifyers[0];
		for(int i = 1; i < identifyers.length; i++) {
			totalAccessString += "." + identifyers[i];
		}
		return "Variable access: " + totalAccessString;
	}

	@Override
	public double evaluate() {
		if(dependency == null) {
			throw new RelayRuntimeException("Attempt to access value of variable access node that has not yet been linked!", this.location);
		}
		return dependency.getCurrentValue();
	}

	public void linkTo(MutableDependentValue dependency) {
		this.dependency  = dependency;
	}

}
