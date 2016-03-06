package relay.parser.symbols;

import java_cup.runtime.ComplexSymbolFactory.Location;
import lib.geom.IndexRectangle2D;
import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.nodes.RootNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.RelaySymbolType;

public abstract class RelaySymbol {

	public final RelaySymbolType type;
	public final RelaySymbol[] children;
	public final LocationRange location;

	public RelaySymbol(LocationRange location, RelaySymbolType type, RelaySymbol[] children) {
		this.type = type;
		this.children = children;
		this.location = location;
	}

	public RelaySymbol(LocationRange location, RelaySymbolType type) {
		this.type = type;
		this.children = new RelaySymbol[]{};
		this.location = location;
	}
	
	public abstract RelayNode compact() throws RelayException;
}
