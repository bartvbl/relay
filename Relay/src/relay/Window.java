package relay;

import lib.geom.IndexRectangle2D;
import relay.events.Event;
import relay.events.EventDispatcher;
import relay.events.EventHandler;
import relay.events.EventType;

public abstract class Window {
	public final EventDispatcher events = new EventDispatcher();
	public final String title;

	private boolean isOpen = false;
	protected IndexRectangle2D dimensions;

	
	public Window(String windowTitle, IndexRectangle2D windowDimensions) {
		this.title = windowTitle;
		this.dimensions = windowDimensions;
	}

	public void open() {
		if(isOpen) {
			throw new RuntimeException("This window has already been opened previously.");
		}
		openWindow();
		events.dispatchEvent(new Event<Window>(EventType.WINDOW_OPENED, this));
		isOpen = true;
	}
	
	public void close() {
		if(!isOpen) {
			throw new RuntimeException("This window is not open.");
		}
		closeWindow();
		events.dispatchEvent(new Event<Window>(EventType.WINDOW_CLOSED, this));
		isOpen = false;
	}
	
	protected abstract void openWindow();
	protected abstract void closeWindow();
	
	
}
