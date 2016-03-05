package relay.events;

public interface EventListener {
	public void handleEvent(Event<?> event);
}
