package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class StatementListNode extends RelaySymbol {
	public StatementListNode(CodeStatementNode listItem, StatementListNode remainingItems) {
		super(RelaySymbolType.STATEMENT_LIST_NODE, new RelaySymbol[]{listItem, remainingItems});
	}
}
