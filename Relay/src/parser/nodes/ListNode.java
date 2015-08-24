package parser.nodes;

public class ListNode extends RelaySymbol {
	public ListNode(RelaySymbol listItem, RelaySymbol remainingItems) {
		super(RelaySymbolType.LIST_ITEM, new RelaySymbol[]{listItem, remainingItems});
	}
}
