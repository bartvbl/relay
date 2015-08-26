package parser.symbols;

import parser.symbols.types.RelaySymbolType;
import parser.symbols.types.StatementType;

public class CodeStatementSymbol extends RelaySymbol {

	public final StatementType statementType;

	public CodeStatementSymbol(StatementType type, ExpressionSymbol fromX, ExpressionSymbol fromY, ExpressionSymbol toX, ExpressionSymbol toY) {
		super(RelaySymbolType.CODE_STATEMENT, new RelaySymbol[]{fromX, fromY, toX, toY});
		this.statementType = type;
	}

}
