package parser.nodes;

import parser.nodes.types.RelaySymbolType;

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
	
	public abstract RelaySymbol simplify();

}
