package relay.parser.symbols;

import relay.nodes.CodeStatementNode;
import relay.nodes.RelayNode;
import relay.parser.symbols.types.RelaySymbolType;
import relay.parser.symbols.types.StatementType;

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
