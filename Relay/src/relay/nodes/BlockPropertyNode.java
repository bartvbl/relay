package relay.nodes;

import relay.types.RelayBlockPropertyType;

public class BlockPropertyNode extends RelayNode {

	public final RelayBlockPropertyType type;
	public final ExpressionNode expression;

	public BlockPropertyNode(RelayBlockPropertyType type, ExpressionNode expression) {
		super(RelayNodeType.BLOCK_PROPERTY, new RelayNode[]{expression});
		this.type = type;
		this.expression = expression;
	}
	
	@Override
	public String toString() {
		return "Block property of type \"" + type + "\"";
	}

}
