package relay.events;

public interface EventHandler {
	public void handleEvent(Event<?> event);
}
