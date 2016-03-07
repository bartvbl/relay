package relay.nodes;

import relay.parser.LocationRange;
import relay.types.RelayBlockPropertyType;

public class BlockPropertyNode extends RelayNode {

	public final RelayBlockPropertyType type;
	public final ExpressionNode expression;

	public BlockPropertyNode(LocationRange identifyerLocation, RelayBlockPropertyType type, ExpressionNode expression) {
		super(new LocationRange(identifyerLocation.start, expression.location.end), RelayNodeType.BLOCK_PROPERTY, new RelayNode[]{expression});
		this.type = type;
		this.expression = expression;
	}
	
	@Override
	public String toString() {
		return "Block property of type \"" + type + "\"";
	}

}
