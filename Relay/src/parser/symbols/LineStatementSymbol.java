package parser.symbols;

import parser.symbols.types.StatementType;
import relay.nodes.CodeStatementNode;
import relay.nodes.ExpressionNode;
import relay.nodes.LineStatementNode;

public class LineStatementSymbol extends CodeStatementSymbol {

	public final ExpressionSymbol fromX;
	public final ExpressionSymbol fromY;
	public final ExpressionSymbol toX;
	public final ExpressionSymbol toY;

	public LineStatementSymbol(ExpressionSymbol fromX, ExpressionSymbol fromY, ExpressionSymbol toX, ExpressionSymbol toY) {
		super(StatementType.LINE, new RelaySymbol[]{fromX, fromY, toX, toY});
		this.fromX = fromX;
		this.fromY = fromY;
		this.toX = toX;
		this.toY = toY;
	}

	@Override
	public CodeStatementNode compactToStatementNode() {
		return new LineStatementNode((ExpressionNode) fromX.compact(), (ExpressionNode) fromY.compact(), (ExpressionNode) toX.compact(), (ExpressionNode) toY.compact());
	}
}
