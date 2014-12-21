package relay.parser;

import relay.data.Expression;

public class ExpressionParser {

	public static Expression parseExpression(FileBuffer buffer) {
		StringBuffer expressionBuffer = new StringBuffer();
		while(buffer.getCurrentCharacter() != '\n') {
			expressionBuffer.append(buffer.getCurrentCharacter());
			buffer.advanceCharacter();
		}
		return new Expression(expressionBuffer.toString());
	}

}
