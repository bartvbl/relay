package parser.nodes;

public class RootNode extends RelaySymbol {
	public RootNode(BlockNode blockSymbol) {
		
		super(RelaySymbolType.ROOT, new RelaySymbol[]{blockSymbol});
	}
}
