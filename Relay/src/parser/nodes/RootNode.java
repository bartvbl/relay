package parser.nodes;

public class RootNode extends RelaySymbol {
	public final BlockNode rootBlock;

	public RootNode(BlockNode blockSymbol) {
		super(RelaySymbolType.ROOT, new RelaySymbol[]{blockSymbol});
		this.rootBlock = blockSymbol;
	}
	
	@Override
	public String toString() {
		return "Parse tree root node";
	}
}
