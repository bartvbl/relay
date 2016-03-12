package relay.exceptions;

import relay.parser.LocationRange;

public class RelayRuntimeException extends RuntimeException {
	public RelayRuntimeException(String message, LocationRange location) {
		super(makeMessage(message, location));
	}
	
	public RelayRuntimeException(Throwable cause) {
		super(cause);
	}
	
	public RelayRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	private static String makeMessage(String message, LocationRange location) {
		return message + "\n" + "At line " + location.start.getLine() + ", column " + location.start.getColumn() + ".";
	}
}
