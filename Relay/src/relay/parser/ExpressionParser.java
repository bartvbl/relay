package relay.parser;

import java.util.ArrayList;

import relay.data.Expression;
import relay.parser.errors.RelayParseException;
import relay.types.ExpressionTokenType;

public class ExpressionParser {

	public static Expression parseExpression(FileBuffer buffer) throws RelayParseException {
		StringBuffer identifyerBuffer = new StringBuffer();
		ArrayList<ExpressionTokenType> tokenTypes = new ArrayList<ExpressionTokenType>();
		ArrayList<String> tokens = new ArrayList<String>();
		
		char currentChar = buffer.getCurrentCharacter();
		while(currentChar != '\r') {
			
			
			ExpressionTokenType tokenType = findTokenType(currentChar, buffer);
			if((tokenType != ExpressionTokenType.IDENTIFYER) && (identifyerBuffer.length() > 0)) {
				tokenTypes.add(ExpressionTokenType.IDENTIFYER);
				tokens.add(identifyerBuffer.toString());
				identifyerBuffer.delete(0, identifyerBuffer.length());
			}
			
			switch(tokenType) {
			case ARGUMENT_LIST_CLOSE:
				break;
			case ARGUMENT_LIST_OPEN:
				break;
			case DOT:
				break;
			case IDENTIFYER:
				identifyerBuffer.append(buffer.getCurrentCharacter());
				break;
			case OPERATOR:
				break;
			default:
				throw new RelayParseException("Expression parser does not yet support this type!", buffer);
			
			}

			buffer.advanceCharacter();
			currentChar = buffer.getCurrentCharacter();
		}
		
		
		
		return new Expression(identifyerBuffer.toString());
	}

	private static ExpressionTokenType findTokenType(char currentChar, FileBuffer buffer) throws RelayParseException {
		for(ExpressionTokenType type : ExpressionTokenType.values()) {
			for(char character : type.applicableCharacters) {
				if(character == currentChar) {
					return type;
				}
			}
		}
		throw new RelayParseException("Character '" + Character.toString(currentChar) + "' is not recognised.", buffer);
	}

}
