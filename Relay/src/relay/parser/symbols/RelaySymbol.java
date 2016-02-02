package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.symbols.types.RelaySymbolType;

public abstract class RelaySymbol {

	public final RelaySymbolType type;
	public final RelaySymbol[] children;

	public RelaySymbol(RelaySymbolType type, RelaySymbol[] children) {
		this.type = type;
		this.children = children;
	}

	public RelaySymbol(RelaySymbolType type) {
		this.type = type;
		this.children = new RelaySymbol[]{};
	}
	
	public abstract RelayNode compact() throws RelayException;
}
