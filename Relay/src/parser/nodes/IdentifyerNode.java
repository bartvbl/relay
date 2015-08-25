package parser.nodes;

public class IdentifyerNode extends RelaySymbol {

	public final String value;

	public IdentifyerNode(String identifyer) {
		super(RelaySymbolType.IDENTIFYER);
		this.value = identifyer;
	}

}