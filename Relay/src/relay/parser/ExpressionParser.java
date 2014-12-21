package relay.parser;

import relay.data.Expression;
import relay.data.Value;

public class ExpressionParser {

	public static Value parseExpression(FileBuffer buffer) {
		StringBuffer expressionBuffer = new StringBuffer();
		while(buffer.getCurrentCharacter() != '\n') {
			expressionBuffer.append(buffer.getCurrentCharacter());
			buffer.advanceCharacter();
		}
		return new Expression(expressionBuffer.toString());
	}

}
