package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.BlockNode;
import relay.nodes.RelayNode;
import relay.nodes.RootNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.RelaySymbolType;

public class RootSymbol extends RelaySymbol {
	public final BlockSymbol rootBlock;

	public RootSymbol(LocationRange locationRange, BlockSymbol blockSymbol) {
		super(locationRange, RelaySymbolType.ROOT, new RelaySymbol[]{blockSymbol});
		this.rootBlock = blockSymbol;
	}
	
	@Override
	public String toString() {
		return "Parse tree root node";
	}

	@Override
	public RelayNode compact() throws RelayException {
		BlockNode mainBlock = (BlockNode) rootBlock.compact();
		return new RootNode(mainBlock);
	}
}
