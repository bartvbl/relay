package relay.events;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher {
	private final HashMap<EventType, ArrayList<EventHandler>> listeners = new HashMap<EventType, ArrayList<EventHandler>>();

	public void dispatchEvent(Event<?> event) {
		if(event.hasParameterObject()) {
			if(!event.type.parameterDataType.isAssignableFrom(event.parameter.getClass())) {
				throw new RuntimeException("Attempted event dispatch with invalid parameter type. Got " + event.parameter.getClass().getName() + ", required " + event.type.parameterDataType.getName() + ".");
			}
		}
		if(!eventTypeExists(event.type)) {
			return;
		}

		ArrayList<EventHandler> eventHandlersList = this.listeners.get(event.type);
		for(EventHandler i : eventHandlersList) {
			i.handleEvent(event);
		}
	}

	public void addEventListener(EventHandler listenerModule, EventType eventType) {
		this.addEventTypeIfNotExistent(eventType);
		ArrayList<EventHandler> listenerList = this.listeners.get(eventType);
		listenerList.add(listenerModule);

	}

	private void addEventTypeIfNotExistent(EventType eventType) {
		if(!eventTypeExists(eventType)) {
			this.listeners.put(eventType, new ArrayList<EventHandler>());
		}
	}

	private boolean eventTypeExists(EventType eventType) {
		return this.listeners.containsKey(eventType);
	}
}