package relay.blockLinking;

import java.util.ArrayList;

import relay.exceptions.RelayException;
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
		visit(rootNode.rootBlock, linkedValues);
		return linkedValues.toArray(new MutableDependentValue[linkedValues.size()]);
	}

	private static void visit(BlockNode block, ArrayList<MutableDependentValue> linkedValues) throws RelayException {
		visitExpressionNode(block.dimensions.left, block.dimensions.left.expression, block.symbolTable, linkedValues);
		visitExpressionNode(block.dimensions.right, block.dimensions.right.expression, block.symbolTable, linkedValues);
		visitExpressionNode(block.dimensions.width, block.dimensions.width.expression, block.symbolTable, linkedValues);
		
		visitExpressionNode(block.dimensions.bottom, block.dimensions.bottom.expression, block.symbolTable, linkedValues);
		visitExpressionNode(block.dimensions.top, block.dimensions.top.expression, block.symbolTable, linkedValues);
		visitExpressionNode(block.dimensions.height, block.dimensions.height.expression, block.symbolTable, linkedValues);
		
		for(VariableDefinitionNode definition : block.variableDefinitions) {
			visitExpressionNode(definition, definition.expression, block.symbolTable, linkedValues);
		}
		
		for(BlockNode childBlock : block.childBlocks) {
			visit(childBlock, linkedValues);
		}
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
		linkedValues.add(value);
		currentValue.registerDependency(value);
	}

}
