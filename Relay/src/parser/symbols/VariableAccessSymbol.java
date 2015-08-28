package parser.symbols;

import java.util.ArrayList;

import parser.symbols.types.ExpressionType;
import parser.symbols.types.RelaySymbolType;
import relay.nodes.RelayNode;
import relay.nodes.VariableAccessNode;

public class VariableAccessSymbol extends ExpressionSymbol {

	public final IdentifyerSymbol identifyer;
	public final boolean furtherAccessRemains;
	public final VariableAccessSymbol remainingAccess;

	public VariableAccessSymbol(IdentifyerSymbol identifyer) {
		super(RelaySymbolType.VARIABLE_ACCESS, ExpressionType.VARIABLE_ACCESS, new RelaySymbol[]{identifyer});
		this.identifyer = identifyer;
		this.remainingAccess = null;
		this.furtherAccessRemains = false;
	}

	public VariableAccessSymbol(IdentifyerSymbol identifyer, VariableAccessSymbol remainingAccess) {
		super(RelaySymbolType.VARIABLE_ACCESS, ExpressionType.VARIABLE_ACCESS, new RelaySymbol[]{identifyer, remainingAccess});
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
		
		return new VariableAccessNode(identifyers.toArray(new String[identifyers.size()]));
	}

}
