package relay.layout;

import java.util.ArrayList;

import relay.nodes.ExpressionNode;
import relay.nodes.VariableAccessNode;
import relay.symbolTable.SymbolTable;

public class DimensionValue {
	private final ExpressionNode expression;
	
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
	
	public DimensionValue[] findDependencies(SymbolTable table) {
		ArrayList<DimensionValue> foundDependencies = new ArrayList<DimensionValue>();
		findDependencies_visitExpressionNode(expression, foundDependencies);
		return null;
	}

	private void findDependencies_visitExpressionNode(ExpressionNode expression, ArrayList<DimensionValue> foundDependencies) {
		if(expression instanceof VariableAccessNode) {
			foundDependencies.add(expression);
		}
		
		
	}
}
