package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class IdentifyerSYmbol extends RelaySymbol {

	public final String value;

	public IdentifyerSYmbol(String identifyer) {
		super(RelaySymbolType.IDENTIFYER);
		this.value = identifyer;
	}
	
	@Override
	public String toString() {
		return "Identifyer named: \"" + value + "\"";
	}

}
