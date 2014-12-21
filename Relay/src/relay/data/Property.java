package relay.data;

import relay.types.PropertyType;

public class Property {
	public final PropertyType type;
	public final Expression value;
	
	public Property(PropertyType type, Expression value) {
		this.type = type;
		this.value = value;
	}
}
