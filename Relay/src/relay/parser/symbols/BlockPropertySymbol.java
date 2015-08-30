package relay.parser.symbols;

import relay.nodes.BlockPropertyNode;
import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.parser.symbols.types.RelaySymbolType;

public class BlockPropertySymbol extends RelaySymbol {

	public final IdentifyerSymbol identifyer;
	public final ExpressionSymbol expression;

	public BlockPropertySymbol(IdentifyerSymbol identifyer, ExpressionSymbol expression) {
		super(RelaySymbolType.BLOCK_PROPERTY, new RelaySymbol[]{identifyer, expression});
		this.identifyer = identifyer;
		this.expression = expression;
	}
	
	@Override
	public String toString() {
		return "Block property of type \"" + identifyer.value + "\"";
	}

	@Override
	public RelayNode compact() {
		return new BlockPropertyNode(identifyer.value, (ExpressionNode)expression.compact());
	}
}
