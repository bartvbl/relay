package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class StatementListSymbol extends RelaySymbol {
	public StatementListSymbol(CodeStatementSymbol listItem, StatementListSymbol remainingItems) {
		super(RelaySymbolType.STATEMENT_LIST_NODE, new RelaySymbol[]{listItem, remainingItems});
	}
}
