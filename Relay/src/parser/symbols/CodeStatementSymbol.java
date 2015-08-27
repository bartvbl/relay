package parser.symbols;

import parser.symbols.types.RelaySymbolType;
import parser.symbols.types.StatementType;
import relay.nodes.CodeStatementNode;
import relay.nodes.RelayNode;

public abstract class CodeStatementSymbol extends RelaySymbol {

	public final StatementType statementType;

	public CodeStatementSymbol(StatementType type, RelaySymbol[] children) {
		super(RelaySymbolType.CODE_STATEMENT, children);
		this.statementType = type;
	}

	public abstract CodeStatementNode compactToStatementNode();
	
	@Override
	public final RelayNode compact() {
		throw new RuntimeException("Code statements should be compacted through the compactToStatementNode(). This is done by the CodeBlockSymbol class.");
	}
}
