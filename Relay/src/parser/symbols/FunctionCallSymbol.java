package parser.symbols;

import parser.symbols.types.ExpressionType;
import parser.symbols.types.RelaySymbolType;

public class FunctionCallSymbol extends ExpressionSymbol {

	public final String functionName;
	public final ParameterListSymbol parameters;

	public FunctionCallSymbol(String identifyer, ParameterListSymbol parameters) {
		super(RelaySymbolType.EXPRESSION, ExpressionType.FUNCTION_CALL, new RelaySymbol[]{parameters});
		this.functionName = identifyer;
		this.parameters = parameters;
	}

	@Override
	public double evaluate() {
		return 0;
	}

}
