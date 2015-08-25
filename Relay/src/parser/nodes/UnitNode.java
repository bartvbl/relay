package parser.nodes;

import parser.nodes.types.RelaySymbolType;
import relay.data.Unit;

public class UnitNode extends RelaySymbol {

	public final Unit value;

	public UnitNode(Unit unit) {
		super(RelaySymbolType.UNIT);
		this.value = unit;
	}

}
