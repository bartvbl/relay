package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.VariableDefinitionNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.RelaySymbolType;

public class VariableDefinitionSymbol extends RelaySymbol {

	public final IdentifyerSymbol identifyer;
	public final ExpressionSymbol value;

	public VariableDefinitionSymbol(LocationRange locationRange, IdentifyerSymbol identifyer, ExpressionSymbol expression) {
		super(locationRange, RelaySymbolType.VARIABLE_DEFINITION);
		this.identifyer = identifyer;
		this.value = expression;
	}

	@Override
	public RelayNode compact() throws RelayException {
		ExpressionNode expressionNode = (ExpressionNode) value.compact();
		return new VariableDefinitionNode(new LocationRange(location.start, expressionNode.location.end), identifyer.value, expressionNode);
	}

}
