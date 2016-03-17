package relay.layout;

import java.util.HashMap;

import lib.geom.Rectangle2D;
import relay.exceptions.RelayException;
import relay.nodes.BlockPropertyNode;
import relay.nodes.expressions.AdditionExpressionNode;
import relay.nodes.expressions.SubtractionExpressionNode;
import relay.nodes.expressions.VariableAccessNode;
import relay.parser.LocationRange;
import relay.parser.symbols.types.ReservedKeyword;
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
		
		this.horizontalDefinition = determineHorizontalDefinitionType(propertyMap);
		this.verticalDefinition = determineVerticalDefinitionType(propertyMap);
		
		createMissingDefinitions(propertyMap);

		this.left = createDimensionValue(RelayBlockPropertyType.left, propertyMap);
		this.right = createDimensionValue(RelayBlockPropertyType.right, propertyMap);
		this.width = createDimensionValue(RelayBlockPropertyType.width, propertyMap);
		
		this.bottom = createDimensionValue(RelayBlockPropertyType.bottom, propertyMap);
		this.top = createDimensionValue(RelayBlockPropertyType.top, propertyMap);
		this.height = createDimensionValue(RelayBlockPropertyType.height, propertyMap);
	}

	private void createMissingDefinitions(HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap) throws RelayException {
		VariableAccessNode leftParentAccessNode = new VariableAccessNode(blockNodeLocation, new String []{"parent", "left"});
		VariableAccessNode rightParentAccessNode = new VariableAccessNode(blockNodeLocation, new String []{"parent", "right"});
		VariableAccessNode widthParentAccessNode = new VariableAccessNode(blockNodeLocation, new String []{"parent", "width"});
		
		VariableAccessNode topParentAccessNode = new VariableAccessNode(blockNodeLocation, new String []{"parent", "top"});
		VariableAccessNode bottomParentAccessNode = new VariableAccessNode(blockNodeLocation, new String []{"parent", "bottom"});
		VariableAccessNode heightParentAccessNode = new VariableAccessNode(blockNodeLocation, new String []{"parent", "height"});
		
		VariableAccessNode leftAccessNode = new VariableAccessNode(blockNodeLocation, new String []{ReservedKeyword.keyword_this.name, "left"});
		VariableAccessNode rightAccessNode = new VariableAccessNode(blockNodeLocation, new String []{ReservedKeyword.keyword_this.name, "right"});
		VariableAccessNode widthAccessNode = new VariableAccessNode(blockNodeLocation, new String []{ReservedKeyword.keyword_this.name, "width"});
		
		VariableAccessNode topAccessNode = new VariableAccessNode(blockNodeLocation, new String []{ReservedKeyword.keyword_this.name, "top"});
		VariableAccessNode bottomAccessNode = new VariableAccessNode(blockNodeLocation, new String []{ReservedKeyword.keyword_this.name, "bottom"});
		VariableAccessNode heightAccessNode = new VariableAccessNode(blockNodeLocation, new String []{ReservedKeyword.keyword_this.name, "height"});

		switch(horizontalDefinition) {
		case MATCH_PARENT:
			propertyMap.put(RelayBlockPropertyType.left, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.left, leftParentAccessNode));
			propertyMap.put(RelayBlockPropertyType.right, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.right, rightParentAccessNode));
			propertyMap.put(RelayBlockPropertyType.width, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.width, widthParentAccessNode));
			break;
		case LEFT_AND_RIGHT:
			SubtractionExpressionNode widthExpression = new SubtractionExpressionNode(blockNodeLocation, rightAccessNode, leftAccessNode);
			propertyMap.put(RelayBlockPropertyType.width, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.width, widthExpression));
			break;
		case LEFT_AND_WIDTH:
			AdditionExpressionNode rightExpression = new AdditionExpressionNode(blockNodeLocation, leftAccessNode, widthAccessNode);
			propertyMap.put(RelayBlockPropertyType.right, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.right, rightExpression));
			break;
		case RIGHT_AND_WIDTH:
			SubtractionExpressionNode leftExpression = new SubtractionExpressionNode(blockNodeLocation, rightAccessNode, widthAccessNode);
			propertyMap.put(RelayBlockPropertyType.left, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.left, leftExpression));
			break;
		case LEFT_ONLY:
			propertyMap.put(RelayBlockPropertyType.right, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.right, rightParentAccessNode));
			widthExpression = new SubtractionExpressionNode(blockNodeLocation, rightAccessNode, leftAccessNode);
			propertyMap.put(RelayBlockPropertyType.width, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.width, widthExpression));
			break;
		case RIGHT_ONLY:
			propertyMap.put(RelayBlockPropertyType.left, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.left, leftParentAccessNode));
			widthExpression = new SubtractionExpressionNode(blockNodeLocation, rightAccessNode, leftAccessNode);
			propertyMap.put(RelayBlockPropertyType.width, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.width, widthExpression));
			break;
		default:
			throw new RelayException("Internal error occurred. Is a dimension type missing?", blockNodeLocation);
		}
		
		switch(verticalDefinition) {
		case MATCH_PARENT:
			propertyMap.put(RelayBlockPropertyType.bottom, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.bottom, bottomParentAccessNode));
			propertyMap.put(RelayBlockPropertyType.top, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.top, topParentAccessNode));
			propertyMap.put(RelayBlockPropertyType.height, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.height, heightParentAccessNode));
			break;
		case BOTTOM_AND_TOP:
			SubtractionExpressionNode heightExpression = new SubtractionExpressionNode(blockNodeLocation, topAccessNode, bottomAccessNode);
			propertyMap.put(RelayBlockPropertyType.height, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.height, heightExpression));
			break;
		case BOTTOM_AND_HEIGHT:
			AdditionExpressionNode topExpression = new AdditionExpressionNode(blockNodeLocation, bottomAccessNode, heightAccessNode);
			propertyMap.put(RelayBlockPropertyType.top, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.top, topExpression));
			break;
		case TOP_AND_HEIGHT:
			SubtractionExpressionNode bottomExpression = new SubtractionExpressionNode(blockNodeLocation, topAccessNode, heightAccessNode);
			propertyMap.put(RelayBlockPropertyType.bottom, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.bottom, bottomExpression));
			break;
		case BOTTOM_ONLY:
			propertyMap.put(RelayBlockPropertyType.top, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.top, topParentAccessNode));
			heightExpression = new SubtractionExpressionNode(blockNodeLocation, topAccessNode, bottomAccessNode);
			propertyMap.put(RelayBlockPropertyType.height, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.height, heightExpression));
			break;
		case TOP_ONLY:
			propertyMap.put(RelayBlockPropertyType.bottom, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.bottom, bottomParentAccessNode));
			heightExpression = new SubtractionExpressionNode(blockNodeLocation, topAccessNode, bottomAccessNode);
			propertyMap.put(RelayBlockPropertyType.height, new BlockPropertyNode(blockNodeLocation, RelayBlockPropertyType.height, heightExpression));
			break;
		default:
			throw new RelayException("Internal error occurred. Is a dimension type missing?", blockNodeLocation);
		}
	}

	private DimensionDefinitionType determineHorizontalDefinitionType(HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap) throws RelayException {
		boolean leftIsDefined = isDefined(RelayBlockPropertyType.left, propertyMap);
		boolean rightIsDefined = isDefined(RelayBlockPropertyType.right, propertyMap);
		boolean widthIsDefined = isDefined(RelayBlockPropertyType.width, propertyMap);
		
		if(leftIsDefined && rightIsDefined) {
			return DimensionDefinitionType.LEFT_AND_RIGHT;
		} else if(leftIsDefined && widthIsDefined) {
			return DimensionDefinitionType.LEFT_AND_WIDTH;
		} else if(rightIsDefined && widthIsDefined) {
			return DimensionDefinitionType.RIGHT_AND_WIDTH;
		} else if(leftIsDefined) {
			return DimensionDefinitionType.LEFT_ONLY;
		} else if(rightIsDefined) {
			return DimensionDefinitionType.RIGHT_ONLY;
		} else if(!leftIsDefined && !widthIsDefined && !rightIsDefined) {
			return DimensionDefinitionType.MATCH_PARENT;
		}
		throw new RelayException("Semantics error: size definition of width only is not allowed.", blockNodeLocation);
	}
	
	private DimensionDefinitionType determineVerticalDefinitionType(HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap) throws RelayException {
		boolean topIsDefined = isDefined(RelayBlockPropertyType.top, propertyMap);
		boolean bottomIsDefined = isDefined(RelayBlockPropertyType.bottom, propertyMap);
		boolean heightIsDefined = isDefined(RelayBlockPropertyType.height, propertyMap);
		
		if(bottomIsDefined && topIsDefined) {
			return DimensionDefinitionType.BOTTOM_AND_TOP;
		} else if(bottomIsDefined && heightIsDefined) {
			return DimensionDefinitionType.BOTTOM_AND_HEIGHT;
		} else if(topIsDefined && heightIsDefined) {
			return DimensionDefinitionType.TOP_AND_HEIGHT;
		} else if(bottomIsDefined) {
			return DimensionDefinitionType.BOTTOM_ONLY;
		} else if(topIsDefined) {
			return DimensionDefinitionType.TOP_ONLY;
		} else if(!bottomIsDefined && !topIsDefined && !heightIsDefined) {
			return DimensionDefinitionType.MATCH_PARENT;
		}
		throw new RelayException("Semantics error: size definition of height only is not allowed.", blockNodeLocation);
	}
	
	private static boolean isDefined(RelayBlockPropertyType type, HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap) {
		return propertyMap.containsKey(type);
	}

	private static DimensionValue createDimensionValue(RelayBlockPropertyType type, HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap) {
		return new DimensionValue(propertyMap.get(type).expression);
	}

	public Rectangle2D calculateCurrentDimensions() {
		double left = this.left.getCurrentValue();
		double right = this.right.getCurrentValue();
		double bottom = this.bottom.getCurrentValue();
		double top = this.top.getCurrentValue();
		return new Rectangle2D(left, bottom, right, top);
	}
}
