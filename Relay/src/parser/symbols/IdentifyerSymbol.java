package parser.symbols;

import parser.symbols.types.RelaySymbolType;

public class IdentifyerSymbol extends RelaySymbol {

	public final String value;

	public IdentifyerSymbol(String identifyer) {
		super(RelaySymbolType.IDENTIFYER);
		this.value = identifyer;
	}
	
	@Override
	public String toString() {
		return "Identifyer named: \"" + value + "\"";
	}

}
