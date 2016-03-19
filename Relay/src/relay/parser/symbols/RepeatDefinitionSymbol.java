package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.BlockNode;
import relay.nodes.RelayNode;
import relay.nodes.RepeatDefinitionNode;
import relay.nodes.expressions.VariableAccessNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.RelaySymbolType;

public class RepeatDefinitionSymbol extends RelaySymbol {

	public final IdentifyerSymbol iterator;
	public final VariableAccessSymbol variable;
	public final BlockSymbol block;

	public RepeatDefinitionSymbol(LocationRange locationRange, IdentifyerSymbol iterator, VariableAccessSymbol variable, BlockSymbol block) {
		super(locationRange, RelaySymbolType.REPEAT_DEFINITION, new RelaySymbol[]{iterator, variable, block});
		this.iterator = iterator;
		this.variable = variable;
		this.block = block;
	}

	@Override
	public RelayNode compact() throws RelayException {
		String identifyer = iterator.value;
		VariableAccessNode variableAccess = (VariableAccessNode) variable.compact();
		BlockNode blockNode = (BlockNode) block.compact();
		
		return new RepeatDefinitionNode(this.location, identifyer, variableAccess, blockNode);
	}

}
