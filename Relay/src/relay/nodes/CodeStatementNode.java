package relay.nodes;

import relay.parser.symbols.types.StatementType;

public abstract class CodeStatementNode extends RelayNode {

	public final StatementType statementType;

	public CodeStatementNode(StatementType type) {
		super(RelayNodeType.CODE_STATEMENT);
		this.statementType = type;
	}
	
	public abstract void evaluate();
	
	@Override
	public String toString() {
		return "Code statement";
	}

}
