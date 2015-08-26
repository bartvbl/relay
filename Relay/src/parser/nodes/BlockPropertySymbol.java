package parser.nodes;

import parser.nodes.types.RelaySymbolType;

public class BlockPropertySymbol extends RelaySymbol {

	public final IdentifyerSYmbol identifyer;
	public final ExpressionSymbol expression;

	public BlockPropertySymbol(IdentifyerSYmbol identifyer, ExpressionSymbol expression) {
		super(RelaySymbolType.BLOCK_PROPERTY, new RelaySymbol[]{identifyer, expression});
		this.identifyer = identifyer;
		this.expression = expression;
	}
	
	@Override
	public String toString() {
		return "Block property of type \"" + identifyer.value + "\"";
	}
}
