package parser.symbols;

import parser.symbols.types.RelaySymbolType;

public class StatementListSymbol extends RelaySymbol {
	public StatementListSymbol(CodeStatementSymbol listItem, StatementListSymbol remainingItems) {
		super(RelaySymbolType.STATEMENT_LIST_NODE, new RelaySymbol[]{listItem, remainingItems});
	}

	public StatementListSymbol(CodeStatementSymbol listItem) {
		super(RelaySymbolType.STATEMENT_LIST_NODE, new RelaySymbol[]{listItem});
	}
}
