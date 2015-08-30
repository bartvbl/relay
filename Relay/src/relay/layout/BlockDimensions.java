package relay.layout;

import java.util.HashMap;

import relay.nodes.BlockPropertyNode;

public class BlockDimensions {
	public final DimensionValue left;
	public final DimensionValue right;
	public final DimensionValue width;
	
	public final DimensionValue bottom;
	public final DimensionValue top;
	public final DimensionValue height;
	
	public BlockDimensions(HashMap<String, BlockPropertyNode> propertyMap) {
		this.left = new DimensionValue();
		this.right = new DimensionValue();
		this.width = new DimensionValue();
		
		this.bottom = new DimensionValue();
		this.top = new DimensionValue();
		this.height = new DimensionValue();
	}
}
