package relay.parser;

import relay.parser.struct.CodeBlock;

public class CodeBlockParser {

	public static boolean isAtCodeBlock(FileBuffer buffer) {
		return buffer.getCurrentCharacter() == '{';
	}

	public static CodeBlock parseCodeBlock(FileBuffer buffer) {
		while(buffer.getCurrentCharacter() != '}') {
			buffer.advanceCharacter();
		}
		return null;
	}

}
