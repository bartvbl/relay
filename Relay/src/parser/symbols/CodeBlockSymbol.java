package parser.symbols;

import java.util.ArrayList;

import parser.symbols.types.RelaySymbolType;
import relay.nodes.CodeBlockNode;
import relay.nodes.CodeStatementNode;
import relay.nodes.RelayNode;

public class CodeBlockSymbol extends RelaySymbol {

	public final StatementListSymbol statementList;

	public CodeBlockSymbol(StatementListSymbol statementList) {
		super(RelaySymbolType.CODE_BLOCK, new RelaySymbol[]{statementList});
		this.statementList = statementList;
	}

	@Override
	public RelayNode compact() {
		ArrayList<CodeStatementNode> statements = new ArrayList<CodeStatementNode>();
		StatementListSymbol currentListSymbol = statementList;
		do { //flatten statements list
			CodeStatementSymbol symbol = currentListSymbol.listItem;
			CodeStatementNode node = symbol.compactToStatementNode();
			statements.add(node);
			currentListSymbol = currentListSymbol.remainingItems;
		} while(currentListSymbol.hasItemsRemaining);
		
		return new CodeBlockNode(statements.toArray(new CodeStatementNode[statements.size()]));
	}

}
