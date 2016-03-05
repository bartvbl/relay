package relay.events;

public class Event<EventParamsDataType> 
{
	public final EventParamsDataType parameter;
	public final EventType type;
	public final String source;

	public static final String UNKNOWN_EVENT_SOURCE = "No source specified.";

	public Event(EventType eventType)
	{
		this.type = eventType;
		this.parameter = null;
		this.source = UNKNOWN_EVENT_SOURCE;
	}

	public Event(EventType eventType, String source)
	{
		this.type = eventType;
		this.parameter = null;
		this.source = source;
	}

	public Event(EventType type, EventParamsDataType eventParameterObject)
	{
		this.type = type;
		this.parameter = eventParameterObject;
		this.source = UNKNOWN_EVENT_SOURCE;
	}

	public Event(EventType type, EventParamsDataType eventParameterObject, String source)
	{
		this.type = type;
		this.parameter = eventParameterObject;
		this.source = source;
	}

	public boolean isSourceBlockSpecified() {
		return this.source != UNKNOWN_EVENT_SOURCE;
	}

	public boolean hasParameterObject()
	{
		return parameter != null;
	}
}