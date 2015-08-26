package relay.nodes;

public class BlockPropertyNode extends RelayNode {

	public final String identifyer;
	public final ExpressionNode expression;

	public BlockPropertyNode(String identifyer, ExpressionNode expression) {
		super(RelayNodeType.BLOCK_PROPERTY);
		this.identifyer = identifyer;
		this.expression = expression;
	}

}
