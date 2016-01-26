package relay;

import relay.events.Event;
import relay.events.EventDispatcher;
import relay.events.EventType;

public abstract class Window {
	private boolean isOpen = false;
	protected final EventDispatcher eventDispatcher = new EventDispatcher();
	
	public void open() {
		if(isOpen) {
			throw new RuntimeException("This window has already been opened previously.");
		}
		openWindow();
		eventDispatcher.dispatchEvent(new Event<Integer>(EventType.WINDOW_OPENED, 100));
		isOpen = true;
	}
	
	public void close() {
		if(!isOpen) {
			throw new RuntimeException("This window is not open.");
		}
		closeWindow();
		isOpen = false;
	}
	
	protected abstract void openWindow();
	protected abstract void closeWindow();
}
