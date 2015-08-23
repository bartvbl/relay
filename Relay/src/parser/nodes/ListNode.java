package parser.nodes;

import java_cup.runtime.Symbol;

public class ListNode extends RelaySymbol {
	public ListNode(Symbol symbol, Symbol listItem, Symbol remainingItems) {
		
		super(symbol, new Symbol[]{listItem, remainingItems});
	}
}
