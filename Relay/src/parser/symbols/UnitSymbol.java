package parser.symbols;

import parser.symbols.types.RelaySymbolType;
import relay.data.Unit;

public class UnitSymbol extends RelaySymbol {

	public final Unit value;

	public UnitSymbol(Unit unit) {
		super(RelaySymbolType.UNIT);
		this.value = unit;
	}

}
