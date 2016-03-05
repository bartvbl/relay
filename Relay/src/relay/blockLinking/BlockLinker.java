package relay.blockLinking;

import relay.layout.DimensionValue;
import relay.layout.MutableDependentValue;
import relay.nodes.BlockNode;
import relay.nodes.ExpressionNode;
import relay.nodes.RootNode;
import relay.nodes.VariableAccessNode;
import relay.symbolTable.SymbolTable;

public class BlockLinker {

	public static void linkBlockExpressions(RootNode rootNode) {
		visit(rootNode.rootBlock);
	}

	private static void visit(BlockNode block) {
		SymbolTable blockSymbolTable = block.symbolTable;
		
		findAndLinkDependencies(block.dimensions.bottom.expression, block.symbolTable);
	}

	private static void findAndLinkDependencies(ExpressionNode expression, SymbolTable symbolTable) {
		if(expression instanceof VariableAccessNode) {
			VariableAccessNode variableAccessNode = (VariableAccessNode) expression;
			MutableDependentValue value = symbolTable.get(variableAccessNode.identifyers);
		}
		
		for(ExpressionNode childNode : expression.expressionChildren) {
			findAndLinkDependencies(childNode, symbolTable);
		}
	}

}
