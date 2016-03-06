package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.RelaySymbolType;

public class RelaySimpleSymbol extends RelaySymbol {

	public RelaySimpleSymbol(LocationRange location) {
		super(location, RelaySymbolType.TOKEN);
	}

	@Override
	public RelayNode compact() throws RelayException {
		throw new RuntimeException("Simple relay symbols should not be compacted!");
	}

}
