package relay.parser.symbols;

import java.util.ArrayList;

import relay.nodes.RelayNode;
import relay.nodes.expressions.VariableAccessNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;
import relay.parser.symbols.types.RelaySymbolType;

public class VariableAccessSymbol extends ExpressionSymbol {

	public final IdentifyerSymbol identifyer;
	public final boolean furtherAccessRemains;
	public final VariableAccessSymbol remainingAccess;

	public VariableAccessSymbol(LocationRange locationRange, IdentifyerSymbol identifyer) {
		super(locationRange, RelaySymbolType.VARIABLE_ACCESS, ExpressionType.VARIABLE_ACCESS, new RelaySymbol[]{identifyer});
		this.identifyer = identifyer;
		this.remainingAccess = null;
		this.furtherAccessRemains = false;
	}

	public VariableAccessSymbol(LocationRange locationRange, IdentifyerSymbol identifyer, VariableAccessSymbol remainingAccess) {
		super(locationRange, RelaySymbolType.VARIABLE_ACCESS, ExpressionType.VARIABLE_ACCESS, new RelaySymbol[]{identifyer, remainingAccess});
		this.identifyer = identifyer;
		this.remainingAccess = remainingAccess;
		this.furtherAccessRemains = true;
	}

	@Override
	public double evaluate() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Variable access node";
	}

	@Override
	public RelayNode compact() {
		VariableAccessSymbol currentVariable = this;
		ArrayList<String> identifyers = new ArrayList<String>();

		while(currentVariable.furtherAccessRemains) {
			identifyers.add(identifyer.value);
			currentVariable = currentVariable.remainingAccess;			
		}
		identifyers.add(currentVariable.identifyer.value); // add the final one
		
		return new VariableAccessNode(new LocationRange(this.location.start, currentVariable.location.end), identifyers.toArray(new String[identifyers.size()]));
	}

}
