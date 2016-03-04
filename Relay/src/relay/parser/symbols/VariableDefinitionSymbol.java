package relay.parser.symbols;

public class VariableDefinitionSymbol extends BlockContentItemSymbol {

	public final IdentifyerSymbol identifyer;
	public final double value;

	public VariableDefinitionSymbol(IdentifyerSymbol identifyer, double value) {
		this.identifyer = identifyer;
		this.value = value;
	}

}
