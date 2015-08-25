package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class IdentifyerNode extends RelaySymbol {

	public final String value;

	public IdentifyerNode(String identifyer) {
		super(RelaySymbolType.IDENTIFYER);
		this.value = identifyer;
	}
	
	@Override
	public String toString() {
		return "Identifyer named: \"" + value + "\"";
	}

}
