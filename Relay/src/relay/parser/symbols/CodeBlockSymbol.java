package relay.parser.symbols;

import java.util.ArrayList;

import relay.exceptions.RelayException;
import relay.nodes.CodeBlockNode;
import relay.nodes.CodeStatementNode;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.RelaySymbolType;

public class CodeBlockSymbol extends RelaySymbol {

	public final StatementListSymbol statementList;

	public CodeBlockSymbol(LocationRange locationRange, StatementListSymbol statementList) {
		super(locationRange, RelaySymbolType.CODE_BLOCK, new RelaySymbol[]{statementList});
		this.statementList = statementList;
	}

	@Override
	public RelayNode compact() throws RelayException {
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
