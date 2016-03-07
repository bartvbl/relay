package relay.nodes;

import relay.parser.LocationRange;

public class CodeBlockNode extends RelayNode {

	public final CodeStatementNode[] statements;

	public CodeBlockNode(LocationRange locationRange, CodeStatementNode[] statements) {
		super(locationRange, RelayNodeType.CODE_BLOCK, statements);
		this.statements = statements;
	}
	
	@Override
	public String toString() {
		return "Code block node";
	}

}
