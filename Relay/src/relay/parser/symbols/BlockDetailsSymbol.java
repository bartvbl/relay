package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.RelayNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.RelaySymbolType;

public class BlockDetailsSymbol extends RelaySymbol {

	public final IdentifyerSymbol blockName;
	public final ParameterListSymbol parameters;

	public BlockDetailsSymbol(LocationRange locationRange, IdentifyerSymbol blockName, ParameterListSymbol parameters) {
		super(locationRange, RelaySymbolType.BLOCK_DETAILS, new RelaySymbol[]{blockName, parameters});
		this.blockName = blockName;
		this.parameters = parameters;
	}

	@Override
	public RelayNode compact() throws RelayException {
		return null;
	}

}
