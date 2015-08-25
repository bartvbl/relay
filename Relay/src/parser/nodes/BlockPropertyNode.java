package parser.nodes;

public class BlockPropertyNode extends RelaySymbol {

	public final IdentifyerNode identifyer;
	public final ExpressionNode expression;

	public BlockPropertyNode(IdentifyerNode identifyer, ExpressionNode expression) {
		super(RelaySymbolType.BLOCK_PROPERTY);
		this.identifyer = identifyer;
		this.expression = expression;
	}

}
