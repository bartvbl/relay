package relay.parser;

import java.util.ArrayList;

import relay.data.Expression;
import relay.types.ExpressionTokenType;

public class ExpressionParser {

	public static Expression parseExpression(FileBuffer buffer) {
		StringBuffer identifyerBuffer = new StringBuffer();
		ArrayList<ExpressionTokenType> tokenTypes = new ArrayList<ExpressionTokenType>();
		ArrayList<String> tokens = new ArrayList<String>();
		
		char currentChar = buffer.getCurrentCharacter();
		while(currentChar != '\n') {
			identifyerBuffer.append(buffer.getCurrentCharacter());

			buffer.advanceCharacter();
			currentChar = buffer.getCurrentCharacter();
		}
		
		
		
		return new Expression(identifyerBuffer.toString());
	}

}
