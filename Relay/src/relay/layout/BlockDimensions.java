package relay.layout;

import java.util.HashMap;

import relay.exceptions.RelayException;
import relay.nodes.BlockPropertyNode;
import relay.parser.LocationRange;
import relay.types.RelayBlockPropertyType;

public class BlockDimensions {
	public final DimensionValue left;
	public final DimensionValue right;
	public final DimensionValue width;
	
	public final DimensionValue bottom;
	public final DimensionValue top;
	public final DimensionValue height;
	
	public final DimensionDefinitionType horizontalDefinition;
	public final DimensionDefinitionType verticalDefinition;
	private final LocationRange blockNodeLocation;
	
	public BlockDimensions(LocationRange blockNodeLocation, HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap) throws RelayException {
		this.blockNodeLocation = blockNodeLocation;
		
		this.left = createDimensionValue(RelayBlockPropertyType.left, propertyMap);
		this.right = createDimensionValue(RelayBlockPropertyType.right, propertyMap);
		this.width = createDimensionValue(RelayBlockPropertyType.width, propertyMap);
		
		this.bottom = createDimensionValue(RelayBlockPropertyType.bottom, propertyMap);
		this.top = createDimensionValue(RelayBlockPropertyType.top, propertyMap);
		this.height = createDimensionValue(RelayBlockPropertyType.height, propertyMap);
		
		this.horizontalDefinition = determineHorizontalDefinitionType();
		this.verticalDefinition = determineVerticalDefinitionType();
	}

	private DimensionDefinitionType determineHorizontalDefinitionType() throws RelayException {
		if(left.isDefined && right.isDefined) {
			return DimensionDefinitionType.LEFT_AND_RIGHT;
		} else if(left.isDefined && width.isDefined) {
			return DimensionDefinitionType.LEFT_AND_WIDTH;
		} else if(right.isDefined && width.isDefined) {
			return DimensionDefinitionType.RIGHT_AND_WIDTH;
		} else if(left.isDefined) {
			return DimensionDefinitionType.LEFT_ONLY;
		} else if(right.isDefined) {
			return DimensionDefinitionType.RIGHT_ONLY;
		} else if(!left.isDefined && !width.isDefined && !right.isDefined) {
			return DimensionDefinitionType.MATCH_PARENT;
		}
		throw new RelayException("Semantics error: size definition of width only is not allowed.", blockNodeLocation);
	}
	
	private DimensionDefinitionType determineVerticalDefinitionType() throws RelayException {
		if(bottom.isDefined && top.isDefined) {
			return DimensionDefinitionType.BOTTOM_AND_TOP;
		} else if(bottom.isDefined && height.isDefined) {
			return DimensionDefinitionType.BOTTOM_AND_HEIGHT;
		} else if(top.isDefined && height.isDefined) {
			return DimensionDefinitionType.TOP_AND_HEIGHT;
		} else if(bottom.isDefined) {
			return DimensionDefinitionType.BOTTOM_ONLY;
		} else if(top.isDefined) {
			return DimensionDefinitionType.TOP_ONLY;
		} else if(!bottom.isDefined && !top.isDefined && !height.isDefined) {
			return DimensionDefinitionType.MATCH_PARENT;
		}
		throw new RelayException("Semantics error: size definition of height only is not allowed.", blockNodeLocation);
	}

	private DimensionValue createDimensionValue(RelayBlockPropertyType type, HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap) {
		BlockPropertyNode blockProperty = propertyMap.get(type);
		if(blockProperty != null) {
			return new DimensionValue(blockProperty.expression);
		} else {
			return new DimensionValue();
		}
	}
}
