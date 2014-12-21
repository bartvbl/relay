package relay.parser;

import relay.data.Expression;
import relay.data.Property;
import relay.parser.errors.RelayParseException;
import relay.parser.types.PropertyType;

public class PropertyParser {

	public static Property parseProperty(FileBuffer buffer) throws RelayParseException {
		PropertyType type = getCurrentKeyword(buffer);
		
		if(type == null) {
			throw new RelayParseException("Unknown property type.", buffer);
		}

		buffer.advanceMultipleCharacters(type.toString().length());
		
		if(buffer.getCurrentCharacter() != ':') {
			throw new RelayParseException("Missing : in property.", buffer);
		}
		
		buffer.advanceToNonWhitespace(); //move away from : character
		
		Expression value = ExpressionParser.parseExpression(buffer);
		return new Property(type, value);
	}
	
	private static PropertyType getCurrentKeyword(FileBuffer buffer) {
		PropertyType[] keywords = PropertyType.values();
		for(int i = 0; i < keywords.length; i++) {
			String keyword = keywords[i].toString();
			if(buffer.lookAhead(keyword.length()).equals(keyword)) {
				return keywords[i];
			}
		}
		return null;
		
	}

	public static boolean isAtProperty(FileBuffer buffer) {
		return getCurrentKeyword(buffer) != null;
	}

}
