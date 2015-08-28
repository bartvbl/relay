package relay.nodes;

public class CodeBlockNode extends RelayNode {

	public final CodeStatementNode[] statements;

	public CodeBlockNode(CodeStatementNode[] statements) {
		super(RelayNodeType.CODE_BLOCK, statements);
		this.statements = statements;
	}
	
	@Override
	public String toString() {
		return "Code block node";
	}

}
