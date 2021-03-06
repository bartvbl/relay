package relay.blockLinking;

import java.util.ArrayList;

import relay.exceptions.RelayException;
import relay.layout.BlockDimensions;
import relay.layout.MutableDependentValue;
import relay.nodes.BlockNode;
import relay.nodes.ExpressionNode;
import relay.nodes.RootNode;
import relay.nodes.VariableDefinitionNode;
import relay.nodes.expressions.VariableAccessNode;
import relay.symbolTable.SymbolTable;
import relay.util.RelayUtil;

public class BlockLinker {

	public static MutableDependentValue[] linkBlockExpressions(RootNode rootNode) throws RelayException {
		ArrayList<MutableDependentValue> linkedValues = new ArrayList<MutableDependentValue>();
		visitBlockDimensions(rootNode.windowDimensions, rootNode.windowSymbolTable, linkedValues);
		visit(rootNode.rootBlock, linkedValues);
		return linkedValues.toArray(new MutableDependentValue[linkedValues.size()]);
	}

	private static void visit(BlockNode block, ArrayList<MutableDependentValue> linkedValues) throws RelayException {
		visitBlockDimensions(block.dimensions, block.symbolTable, linkedValues);
		
		for(VariableDefinitionNode definition : block.variableDefinitions) {
			linkedValues.add(definition);
			visitExpressionNode(definition, definition.expression, block.symbolTable, linkedValues);
		}
		
		for(BlockNode childBlock : block.childBlocks) {
			visit(childBlock, linkedValues);
		}
	}

	private static void visitBlockDimensions(BlockDimensions dimensions, SymbolTable symbolTable, ArrayList<MutableDependentValue> linkedValues) throws RelayException {
		visitExpressionNode(dimensions.left, dimensions.left.expression, symbolTable, linkedValues);
		visitExpressionNode(dimensions.right, dimensions.right.expression, symbolTable, linkedValues);
		visitExpressionNode(dimensions.width, dimensions.width.expression, symbolTable, linkedValues);
		
		visitExpressionNode(dimensions.bottom, dimensions.bottom.expression, symbolTable, linkedValues);
		visitExpressionNode(dimensions.top, dimensions.top.expression, symbolTable, linkedValues);
		visitExpressionNode(dimensions.height, dimensions.height.expression, symbolTable, linkedValues);
		
		linkedValues.add(dimensions.left);
		linkedValues.add(dimensions.right);
		linkedValues.add(dimensions.width);
		
		linkedValues.add(dimensions.bottom);
		linkedValues.add(dimensions.top);
		linkedValues.add(dimensions.height);
	}

	private static void visitExpressionNode(MutableDependentValue currentValue, ExpressionNode expression, SymbolTable symbolTable, ArrayList<MutableDependentValue> linkedValues) throws RelayException {
		if(expression instanceof VariableAccessNode) {
			VariableAccessNode variableAccessNode = (VariableAccessNode) expression;
			linkVariableAccessNode(currentValue, variableAccessNode, symbolTable, linkedValues);
		}
		
		for(ExpressionNode childNode : expression.expressionChildren) {
			visitExpressionNode(currentValue, childNode, symbolTable, linkedValues);
		}
	}

	private static void linkVariableAccessNode(MutableDependentValue currentValue, VariableAccessNode variableAccessNode, SymbolTable symbolTable, ArrayList<MutableDependentValue> linkedValues) throws RelayException {
		MutableDependentValue value = symbolTable.get(variableAccessNode.identifyers);
		
		if(value == null) {
			throw new RelayException("No block, property or variable named \"" + RelayUtil.mergeVariableAccessStrings(variableAccessNode.identifyers) + "\" was found.", variableAccessNode.location);
		}
		
		variableAccessNode.linkTo(value);
		currentValue.registerDependency(value);
	}

}
