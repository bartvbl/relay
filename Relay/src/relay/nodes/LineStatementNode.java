package relay.nodes;

import parser.symbols.ExpressionSymbol;
import parser.symbols.RelaySymbol;
import parser.symbols.types.StatementType;

public class LineStatementNode extends CodeStatementNode {

	private final ExpressionNode fromX;
	private final ExpressionNode fromY;
	private final ExpressionNode toX;
	private final ExpressionNode toY;

	public LineStatementNode(ExpressionNode fromX, ExpressionNode fromY, ExpressionNode toX, ExpressionNode toY) {
		super(StatementType.LINE); // children are not passed in here because they should be exclusive to this node.
		this.fromX = fromX;
		this.fromY = fromY;
		this.toX = toX;
		this.toY = toY;
	}

	@Override
	public void evaluate() {
		
	}

}
