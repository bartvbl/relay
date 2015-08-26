package relay.parser;

import java.util.ArrayList;

import relay.nodes.Expression;
import relay.parser.errors.RelayParseException;
import relay.types.ExpressionTokenType;

public class ExpressionParser {

	public static Expression parseExpression(FileBuffer buffer) throws RelayParseException {
		ArrayList<ExpressionTokenType> tokenTypes = new ArrayList<ExpressionTokenType>();
		ArrayList<String> tokens = new ArrayList<String>();
		
		char currentChar = buffer.getCurrentCharacter();
		while(currentChar != '\r') {
			if(Character.isWhitespace(currentChar)) {
				buffer.advanceCharacter();
				currentChar = buffer.getCurrentCharacter();
				continue; //ignore whitespace
			}
			
			ExpressionTokenType tokenType = findTokenType(currentChar, buffer);
			
			switch(tokenType) {
			case ARGUMENT_LIST_CLOSE:
				tokenTypes.add(ExpressionTokenType.ARGUMENT_LIST_CLOSE);
				tokens.add(""+currentChar);
				break;
			case ARGUMENT_LIST_OPEN:
				tokenTypes.add(ExpressionTokenType.ARGUMENT_LIST_OPEN);
				tokens.add(""+currentChar);
				break;
			case DOT:
				tokenTypes.add(ExpressionTokenType.DOT);
				tokens.add(""+currentChar);
				break;
			case IDENTIFYER:
				String identifyer = readTokenSeries(buffer, tokenType, currentChar);
				tokenTypes.add(tokenType);
				tokens.add(identifyer.toString());
				break;
			case OPERATOR:
				tokenTypes.add(ExpressionTokenType.OPERATOR);
				tokens.add(""+currentChar);
				break;
			case NUMBER:
				identifyer = readTokenSeries(buffer, tokenType, currentChar);
				tokenTypes.add(tokenType);
				tokens.add(identifyer.toString());
				break;
			default:
				throw new RelayParseException("Expression parser does not yet support this type!", buffer);
			}

			buffer.advanceCharacter();
			currentChar = buffer.getCurrentCharacter();
		}
		
		return new Expression(tokenTypes, tokens);
	}

	private static String readTokenSeries(FileBuffer buffer, ExpressionTokenType tokenType, char currentChar) throws RelayParseException {
		StringBuffer identifyerBuffer = new StringBuffer();
		identifyerBuffer.append(currentChar);
		char nextCharacter = buffer.lookAhead(2).charAt(1);
		if(!Character.isWhitespace(nextCharacter)) {
			ExpressionTokenType nextTokenType = findTokenType(nextCharacter, buffer);
			while(nextTokenType == tokenType) {
				identifyerBuffer.append(nextCharacter);
				buffer.advanceCharacter();
				nextCharacter = buffer.lookAhead(2).charAt(1);
				if(Character.isWhitespace(nextCharacter)) {
					break;
				}
				nextTokenType = findTokenType(nextCharacter, buffer);
			}
		}
		
		return identifyerBuffer.toString();
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
