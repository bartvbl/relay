package relay.parser.symbols;

import relay.parser.LocationRange;

public class VariableDefinitionSymbol extends BlockContentItemSymbol {

	public final IdentifyerSymbol identifyer;
	public final double value;

	public VariableDefinitionSymbol(LocationRange locationRange, IdentifyerSymbol identifyer, double value) {
		super(locationRange);
		this.identifyer = identifyer;
		this.value = value;
	}

}
