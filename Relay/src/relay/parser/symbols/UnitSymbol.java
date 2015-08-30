package relay.parser.symbols;

import relay.data.Unit;
import relay.nodes.RelayNode;
import relay.parser.symbols.types.RelaySymbolType;

public class UnitSymbol extends RelaySymbol {

	public final Unit value;

	public UnitSymbol(Unit unit) {
		super(RelaySymbolType.UNIT);
		this.value = unit;
	}

	@Override
	public RelayNode compact() {
		throw new RuntimeException("Unit should be merged into other nodes.");
	}

}
