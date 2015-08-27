package relay.nodes;

import parser.symbols.types.StatementType;

public class CodeStatementNode extends RelayNode {

	public CodeStatementNode(StatementType line) {
		super(RelayNodeType.CODE_STATEMENT);
	}

}
