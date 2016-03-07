package relay.parser.symbols;

import relay.parser.LocationRange;

public class VariableDefinitionSymbol extends BlockContentItemSymbol {

	public final IdentifyerSymbol identifyer;
	public final ExpressionSymbol value;

	public VariableDefinitionSymbol(LocationRange locationRange, IdentifyerSymbol identifyer, ExpressionSymbol expression) {
		super(locationRange);
		this.identifyer = identifyer;
		this.value = expression;
	}

}
