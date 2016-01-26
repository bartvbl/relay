package relay.events;

import lib.geom.Dimension2D;
import lib.geom.Point2D;
import relay.Window;

public enum EventType 
{										// Attachment:
	
	WINDOW_OPENED(Window.class),		// Instance of Window
	WINDOW_CLOSED(Window.class), 		// Instance of Window
	WINDOW_RESIZED(Dimension2D.class), 	// New size of window
	WINDOW_MOVED(Point2D.class),		// New location of window
	;
	
	public final Class<?> parameterDataType;

	private EventType(Class<?> dataType) {
		this.parameterDataType = dataType;
	}
}
