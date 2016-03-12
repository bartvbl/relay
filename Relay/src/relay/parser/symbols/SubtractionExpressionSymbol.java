package relay.parser.symbols;

import relay.exceptions.RelayException;
import relay.nodes.ExpressionNode;
import relay.nodes.RelayNode;
import relay.nodes.expressions.AdditionExpressionNode;
import relay.nodes.expressions.SubtractionExpressionNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ExpressionType;
import relay.parser.symbols.types.RelaySymbolType;


public class SubtractionExpressionSymbol extends ExpressionSymbol {

	private final ExpressionSymbol leftHandSide;
	private final ExpressionSymbol rightHandSide;

	public SubtractionExpressionSymbol(LocationRange locationRange, ExpressionSymbol leftHandSide, ExpressionSymbol rightHandSide) {
		super(locationRange, ExpressionType.SUBTRACTION, new RelaySymbol[]{leftHandSide, rightHandSide});
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}

	@Override
	public RelayNode compact() throws RelayException {
		ExpressionNode leftHand = (ExpressionNode) leftHandSide.compact();
		ExpressionNode rightHand = (ExpressionNode) rightHandSide.compact();
		return new SubtractionExpressionNode(new LocationRange(leftHand.location.start, rightHand.location.end), leftHand, rightHand);
	}

}
