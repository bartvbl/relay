package parser.nodes;

import relay.data.Unit;

public class UnitNode extends RelaySymbol {

	public final Unit value;

	public UnitNode(Unit unit) {
		super(RelaySymbolType.UNIT);
		this.value = unit;
	}

}
