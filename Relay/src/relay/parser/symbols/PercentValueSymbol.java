package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.PercentValueNode;
import relay.nodes.RelayNode;
import relay.nodes.expressions.VariableAccessNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;

public class PercentValueSymbol extends ExpressionSymbol {

	private final VariableAccessSymbol property;
	private final Double value;

	public PercentValueSymbol(LocationRange locationRange, Double value, VariableAccessSymbol property) {
		super(locationRange, ExpressionType.PERCENTAGE_VALUE, new RelaySymbol[]{property});
		this.property = property;
		this.value = value;
	}

	@Override
	public RelayNode compact() throws RelayException {
		VariableAccessNode accessNode = (VariableAccessNode) property.compact();
		return new PercentValueNode(this.location, value, accessNode);
	}

}
