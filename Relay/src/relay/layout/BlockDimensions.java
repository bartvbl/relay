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
		this.left = createDimensionValue(DimensionValueType.left, propertyMap);
		this.right = createDimensionValue(DimensionValueType.right, propertyMap);
		this.width = createDimensionValue(DimensionValueType.width, propertyMap);
		
		this.bottom = createDimensionValue(DimensionValueType.bottom, propertyMap);
		this.top = createDimensionValue(DimensionValueType.top, propertyMap);
		this.height = createDimensionValue(DimensionValueType.height, propertyMap);
	}

	private DimensionValue createDimensionValue(DimensionValueType type, HashMap<String, BlockPropertyNode> propertyMap) {
		BlockPropertyNode blockProperty = propertyMap.get(type.toString());
		if(blockProperty != null) {
			return new DimensionValue(blockProperty.expression);
		} else {
			return new DimensionValue();
		}
	}
}
