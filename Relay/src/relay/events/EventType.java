package relay.events;

import relay.Window;

public enum EventType 
{
	WINDOW_OPENED(Window.class),
	WINDOW_CLOSED(Window.class),
	;
	
	public final Class<?> parameterDataType;

	private EventType(Class<?> dataType) {
		this.parameterDataType = dataType;
	}
}
