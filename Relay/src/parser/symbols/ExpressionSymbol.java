package parser.symbols;

import parser.symbols.types.ExpressionType;
import parser.symbols.types.RelaySymbolType;

public abstract class ExpressionSymbol extends RelaySymbol {

	public final ExpressionType expressionType;

	public ExpressionSymbol(RelaySymbolType type, ExpressionType expressionType) {
		super(type);
		this.expressionType = expressionType;
	}
	
	public ExpressionSymbol(RelaySymbolType type, ExpressionType expressionType, RelaySymbol[] children) {
		super(type, children);
		this.expressionType = expressionType;
	}
	
	public abstract double evaluate();

}
