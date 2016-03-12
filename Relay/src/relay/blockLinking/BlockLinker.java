package relay.blockLinking;

import relay.exceptions.RelayException;
import relay.layout.BlockDimensions;
import relay.layout.DimensionValue;
import relay.layout.MutableDependentValue;
import relay.nodes.BlockNode;
import relay.nodes.ExpressionNode;
import relay.nodes.RootNode;
import relay.nodes.VariableDefinitionNode;
import relay.nodes.expressions.VariableAccessNode;
import relay.symbolTable.SymbolTable;
import relay.util.RelayUtil;

public class BlockLinker {

	public static void linkBlockExpressions(RootNode rootNode) throws RelayException {
		visit(rootNode.rootBlock);
	}

	private static void visit(BlockNode block) throws RelayException {
		findAndLinkDependencies(block.dimensions.left, block.symbolTable);
		findAndLinkDependencies(block.dimensions.right, block.symbolTable);
		findAndLinkDependencies(block.dimensions.width, block.symbolTable);
		
		findAndLinkDependencies(block.dimensions.bottom, block.symbolTable);
		findAndLinkDependencies(block.dimensions.top, block.symbolTable);
		findAndLinkDependencies(block.dimensions.height, block.symbolTable);
		
		for(VariableDefinitionNode definition : block.variableDefinitions) {
			visitExpressionNode(definition.expression, block.symbolTable);
		}
		
		for(BlockNode childBlock : block.childBlocks) {
			visit(childBlock);
		}
	}

	private static void findAndLinkDependencies(DimensionValue dimensions, SymbolTable symbolTable) throws RelayException {
		visitExpressionNode(dimensions.expression, symbolTable);
	}

	private static void visitExpressionNode(ExpressionNode expression, SymbolTable symbolTable) throws RelayException {
		if(expression instanceof VariableAccessNode) {
			VariableAccessNode variableAccessNode = (VariableAccessNode) expression;
			MutableDependentValue value = symbolTable.get(variableAccessNode.identifyers);
			if(value == null) {
				throw new RelayException("No block, property or variable named \"" + RelayUtil.mergeVariableAccessStrings(variableAccessNode.identifyers) + "\" was found.", expression.location);
			}
		}
		
		for(ExpressionNode childNode : expression.expressionChildren) {
			visitExpressionNode(childNode, symbolTable);
		}
	}

}
