package parser.nodes;

public class CodeBlockNode extends RelaySymbol {

	public final StatementListNode statementList;

	public CodeBlockNode(StatementListNode statementList) {
		super(RelaySymbolType.CODE_BLOCK, new RelaySymbol[]{statementList});
		this.statementList = statementList;
	}

}
