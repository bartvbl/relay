package parser.symbols;

import parser.symbols.types.RelaySymbolType;
import relay.nodes.RelayNode;

public class BlockSymbol extends RelaySymbol {

	public final IdentifyerSymbol nameNode;
	public final BlockContentListSymbol childList;

	public BlockSymbol(IdentifyerSymbol blockName, BlockContentListSymbol childList) {
		super(RelaySymbolType.BLOCK, new RelaySymbol[]{childList});
		this.nameNode = blockName;
		this.childList = childList;
	}

	@Override
	public String toString() {
		return "Block named \"" + nameNode.value + "\"";
	}

	@Override
	public RelayNode compact() {
		return null;
	}

}
