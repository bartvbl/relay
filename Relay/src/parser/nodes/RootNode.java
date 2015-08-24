package parser.nodes;

public class RootNode extends RelaySymbol {
	public RootNode(RelaySymbol blockSymbol) {
		
		super(RelaySymbolType.ROOT, new RelaySymbol[]{blockSymbol});
	}
}
