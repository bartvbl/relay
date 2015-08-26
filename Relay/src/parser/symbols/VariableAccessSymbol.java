package parser.symbols;

import parser.symbols.types.ExpressionType;
import parser.symbols.types.RelaySymbolType;

public class VariableAccessSymbol extends ExpressionSymbol {

	public final IdentifyerSymbol identifyer;
	public final boolean furtherAccessRemains;

	public VariableAccessSymbol(IdentifyerSymbol identifyer) {
		super(RelaySymbolType.VARIABLE_ACCESS, ExpressionType.VARIABLE_ACCESS, new RelaySymbol[]{identifyer});
		this.identifyer = identifyer;
		this.furtherAccessRemains = false;
	}

	public VariableAccessSymbol(IdentifyerSymbol identifyer, VariableAccessSymbol remainingAccess) {
		super(RelaySymbolType.VARIABLE_ACCESS, ExpressionType.VARIABLE_ACCESS, new RelaySymbol[]{identifyer, remainingAccess});
		this.identifyer = identifyer;
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

}
