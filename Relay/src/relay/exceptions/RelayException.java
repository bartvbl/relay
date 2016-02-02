package relay.exceptions;

public class RelayException extends Exception {
	public RelayException(String message) {
		super(message);
	}
	
	public RelayException(Throwable cause) {
		super(cause);
	}
	
	public RelayException(String message, Throwable cause) {
		super(message, cause);
	}
}
