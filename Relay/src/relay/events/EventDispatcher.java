package relay.events;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher {
	private final HashMap<EventType, ArrayList<EventListener>> listeners = new HashMap<EventType, ArrayList<EventListener>>();
	private final HashMap<String, HashMap<EventType, ArrayList<EventListener>>> listenersBySource = new HashMap<String, HashMap<EventType, ArrayList<EventListener>>>();

	public void dispatchEvent(Event<?> event) {
		
		// Validate event parameter with type specification
		if(event.hasParameterObject()) {
			if(!event.type.parameterDataType.isAssignableFrom(event.parameter.getClass())) {
				throw new RuntimeException("Attempted event dispatch with invalid parameter type. Got " + event.parameter.getClass().getName() + ", required " + event.type.parameterDataType.getName() + ".");
			}
		}
		
		if(!eventTypeExists(event.type)) {
			return;
		}

		ArrayList<EventListener> eventHandlersList = this.listeners.get(event.type);
		callEventListeners(event, eventHandlersList);
		
		if(event.isSourceBlockSpecified() && listenersBySource.containsKey(event.source)) {
			HashMap<EventType, ArrayList<EventListener>> listenersToBlock = listenersBySource.get(event.source);
			if(listenersToBlock.containsKey(event.type)) {
				ArrayList<EventListener> listenersToDispatch = listenersToBlock.get(event.type);
				callEventListeners(event, listenersToDispatch);
			}
		}
	}

	private void callEventListeners(Event<?> event, ArrayList<EventListener> eventHandlersList) {
		for(EventListener i : eventHandlersList) {
			i.handleEvent(event);
		}
	}

	public void addEventListener(EventListener listener, EventType type) {
		this.addEventTypeIfNotExistent(type);
		ArrayList<EventListener> listenerList = this.listeners.get(type);
		listenerList.add(listener);
	}
	
	public void addEventListenerToBlock(EventListener listener, EventType type, String blockName) {
		if(!listenersBySource.containsKey(blockName)) {
			listenersBySource.put(blockName, new HashMap<EventType, ArrayList<EventListener>>());
		}
		HashMap<EventType, ArrayList<EventListener>> blockListeners = listenersBySource.get(blockName);
		if(!blockListeners.containsKey(type)) {
			blockListeners.put(type, new ArrayList<EventListener>());
		}
		blockListeners.get(type).add(listener);
	}

	private void addEventTypeIfNotExistent(EventType eventType) {
		if(!eventTypeExists(eventType)) {
			this.listeners.put(eventType, new ArrayList<EventListener>());
		}
	}

	private boolean eventTypeExists(EventType eventType) {
		return this.listeners.containsKey(eventType);
	}
}