package relay.data;

import relay.parser.types.PropertyType;

public class Property {
	public final PropertyType type;
	public final Value value;
	
	public Property(PropertyType type, Value value) {
		this.type = type;
		this.value = value;
	}
}
