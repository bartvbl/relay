package relay.parser.symbols;

import relay.nodes.RelayNode;
import relay.parser.symbols.types.RelaySymbolType;

public class StatementListSymbol extends RelaySymbol {
	public final CodeStatementSymbol listItem;
	public final boolean hasItemsRemaining;
	public final StatementListSymbol remainingItems;

	public StatementListSymbol(CodeStatementSymbol listItem, StatementListSymbol remainingItems) {
		super(RelaySymbolType.STATEMENT_LIST_NODE, new RelaySymbol[]{listItem, remainingItems});
		
		this.listItem = listItem;
		this.hasItemsRemaining = true;
		this.remainingItems = remainingItems;
	}

	public StatementListSymbol(CodeStatementSymbol listItem) {
		super(RelaySymbolType.STATEMENT_LIST_NODE, new RelaySymbol[]{listItem});
		
		this.listItem = listItem;
		this.hasItemsRemaining = false;
		this.remainingItems = null;
	}

	@Override
	public RelayNode compact() {
		throw new RuntimeException("Should be performed by the code block node..");
	}
}
