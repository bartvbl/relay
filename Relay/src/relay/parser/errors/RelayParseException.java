package relay.parser.errors;

import relay.parser.FileBuffer;

public class RelayParseException extends Exception {

	public RelayParseException(String message, FileBuffer buffer) {
		super("Parse error at line " + buffer.getCurrentLineNumber() + ", char " + buffer.getCurrentColumnNumber() + ": " + message);
	}

}
