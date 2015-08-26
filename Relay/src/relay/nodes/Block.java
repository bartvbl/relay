package relay.nodes;

import java.util.ArrayList;

public class Block {
	private ArrayList<Property> properties = new ArrayList<Property>();
	private ArrayList<Block> children = new ArrayList<Block>();
	
	public final String name;

	public Block(String name) {
		this.name = name;
	}

	public void addProperty(Property property) {
		properties.add(property);
	}

	public void addChild(Block child) {
		children.add(child);
	}

	public Block[] getChildren() {
		return children.toArray(new Block[children.size()]);
	}
	
	public Property[] getProperties() {
		return properties.toArray(new Property[properties.size()]);
	}

}
