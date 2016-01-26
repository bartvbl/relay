package relay.events;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher {
	private final HashMap<EventType, ArrayList<EventHandler>> listeners = new HashMap<EventType, ArrayList<EventHandler>>();

	public void dispatchEvent(Event<?> event) {
		if (!eventTypeExists(event.eventType)) {
			return;
		}

		ArrayList<EventHandler> eventHandlersList = this.listeners.get(event.eventType);
		for (EventHandler i : eventHandlersList) {
			i.handleEvent(event);
		}
	}

	public void addEventListener(EventHandler listenerModule, EventType eventType) {
		this.addEventTypeIfNotExistent(eventType);
		ArrayList<EventHandler> listenerList = this.listeners.get(eventType);
		listenerList.add(listenerModule);

	}

	private void addEventTypeIfNotExistent(EventType eventType) {
		if (!eventTypeExists(eventType)) {
			this.listeners.put(eventType, new ArrayList<EventHandler>());
		}
	}

	private boolean eventTypeExists(EventType eventType) {
		return this.listeners.containsKey(eventType);
	}
}