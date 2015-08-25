package parser.nodes;

import parser.nodes.types.RelaySymbolType;
import parser.nodes.types.StatementType;

public class CodeStatementNode extends RelaySymbol {

	public final StatementType statementType;

	public CodeStatementNode(StatementType type, ExpressionNode fromX, ExpressionNode fromY, ExpressionNode toX, ExpressionNode toY) {
		super(RelaySymbolType.CODE_STATEMENT, new RelaySymbol[]{fromX, fromY, toX, toY});
		this.statementType = type;
	}

}
