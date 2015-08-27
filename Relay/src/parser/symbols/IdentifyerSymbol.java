package parser.symbols;

import parser.symbols.types.RelaySymbolType;
import relay.nodes.RelayNode;

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

	@Override
	public RelayNode compact() {
		throw new RuntimeException("Identifyers should be read out from this symbol. Not be regenerated as a separate node into the AST.");
	}

}
