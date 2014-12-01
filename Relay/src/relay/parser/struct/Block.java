package relay.parser.struct;

import java.util.ArrayList;

public class Block {
	private ArrayList<Property> properties = new ArrayList<Property>();
	private ArrayList<Block> children = new ArrayList<Block>();

	public void addProperty(Property property) {
		properties.add(property);
	}

	public void addChild(Block child) {
		children.add(child);
	}

}
