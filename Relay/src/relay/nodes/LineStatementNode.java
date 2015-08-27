package relay.nodes;

import parser.symbols.ExpressionSymbol;
import parser.symbols.types.StatementType;

public class LineStatementNode extends CodeStatementNode {

	public LineStatementNode(ExpressionSymbol fromX, ExpressionSymbol fromY, ExpressionSymbol toX, ExpressionSymbol toY) {
		super(StatementType.LINE);
	}

}
