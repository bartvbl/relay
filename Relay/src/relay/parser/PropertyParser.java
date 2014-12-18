package relay.parser;

import relay.parser.errors.RelayParseException;
import relay.parser.struct.Property;
import relay.parser.struct.Value;
import relay.parser.types.PropertyType;

public class PropertyParser {

	public static Property parseProperty(FileBuffer buffer) {
		PropertyType type = getCurrentKeyword(buffer);
		buffer.advanceMultipleCharacters(type.toString().length());
		
		if(type == null) {
			throw new RelayParseException("Unknown property type.");
		}
		
		if(buffer.getCurrentCharacter() != ':') {
			throw new RelayParseException("Missing : in property.");
		}
		
		Value value = ExpressionParser.parseExpression(buffer);
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
