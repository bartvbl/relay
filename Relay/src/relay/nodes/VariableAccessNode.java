package relay.nodes;

import java.util.Arrays;

import relay.parser.symbols.types.ExpressionType;

public class VariableAccessNode extends ExpressionNode {

	public final String[] identifyers;

	public VariableAccessNode(String[] identifyers) {
		super(ExpressionType.VARIABLE_ACCESS);
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
		throw new RuntimeException("I don't have a symbol table :(");
	}

}
