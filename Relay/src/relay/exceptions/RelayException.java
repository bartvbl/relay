package relay.exceptions;

import relay.parser.LocationRange;

public class RelayException extends Exception {
	public RelayException(String message, LocationRange location) {
		super(makeMessage(message, location));
	}
	
	public RelayException(Throwable cause) {
		super(cause);
	}
	
	public RelayException(String message, Throwable cause) {
		super(message, cause);
	}
	
	private static String makeMessage(String message, LocationRange location) {
		return message + "\n" + "At line " + location.start.getLine() + ", column " + location.start.getColumn() + ".";
	}
}
