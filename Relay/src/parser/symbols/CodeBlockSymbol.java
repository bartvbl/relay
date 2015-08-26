package parser.symbols;

import parser.symbols.types.RelaySymbolType;

public class CodeBlockSymbol extends RelaySymbol {

	public final StatementListSymbol statementList;

	public CodeBlockSymbol(StatementListSymbol statementList) {
		super(RelaySymbolType.CODE_BLOCK, new RelaySymbol[]{statementList});
		this.statementList = statementList;
	}

}
