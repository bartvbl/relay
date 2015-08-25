package parser.nodes;

import java_cup.runtime.Symbol;

public class BlockNode extends RelaySymbol {

	private final IdentifyerNode nameNode;

	public BlockNode(IdentifyerNode blockName, ListNode childList) {
		super(RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.nameNode = blockName;
	}

}
