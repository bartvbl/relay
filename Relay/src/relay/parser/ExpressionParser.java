package relay.parser;

import relay.parser.struct.Value;

public class ExpressionParser {

	public static Value parseExpression(FileBuffer buffer) {
		while(buffer.getCurrentCharacter() != '\n') {
			buffer.advanceCharacter();
		}
		return new Value("chicken.");
	}

}
