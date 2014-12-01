package relay.parser;

import relay.parser.struct.Property;

public class PropertyParser {
	private static final String[] keywords = {"left", "right", "top", "bottom"};

	public static Property parseProperty(FileBuffer buffer) {
		return null;
	}
	
	private static String getCurrentKeyword(FileBuffer buffer) {
		for(int i = 0; i < keywords.length; i++) {
			String keyword = keywords[i];
			if(buffer.lookAhead(keyword.length()).equals(keyword)) {
				return keyword;
			}
		}
		return null;
	}

	public static boolean isAtProperty(FileBuffer buffer) {
		return getCurrentKeyword(buffer) != null;
	}

}
