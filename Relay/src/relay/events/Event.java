package relay.events;

public class Event<EventParamsDataType> 
{
	public final EventParamsDataType parameter;
	public final EventType type;
	
	public Event(EventType eventType)
	{
		this.type = eventType;
		this.parameter = null;
	}
	public Event(EventType type, EventParamsDataType eventParameterObject)
	{
		this.type = type;
		this.parameter = eventParameterObject;
	}
	
	public boolean hasParameterObject()
	{
		return parameter != null;
	}
}