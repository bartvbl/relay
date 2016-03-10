package relay.layout.windowRoot;

import java.awt.geom.Rectangle2D;
import java.util.HashMap;

import lib.geom.IndexRectangle2D;
import relay.data.Unit;
import relay.exceptions.RelayException;
import relay.layout.BlockDimensions;
import relay.nodes.BlockPropertyNode;
import relay.nodes.expressions.MutableValueExpressionNode;
import relay.parser.LocationRange;
import relay.types.RelayBlockPropertyType;
import java_cup.runtime.ComplexSymbolFactory.Location;

public class WindowDimensions extends BlockDimensions {

	private static final Location defaultLocation = new Location(0, 0);
	private static final LocationRange defaultLocationRange = new LocationRange(defaultLocation, defaultLocation);
	
	public WindowDimensions(IndexRectangle2D windowDimensions) throws RelayException {
		super(defaultLocationRange, createPropertyMap(windowDimensions));
	}

	private static HashMap<RelayBlockPropertyType, BlockPropertyNode> createPropertyMap(IndexRectangle2D windowDimensions) {
		HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap = new HashMap<RelayBlockPropertyType, BlockPropertyNode>();
		
		MutableValueExpressionNode leftExpression = new MutableValueExpressionNode(defaultLocationRange, windowDimensions.x1, Unit.PIXELS);
		MutableValueExpressionNode rightExpression = new MutableValueExpressionNode(defaultLocationRange, windowDimensions.x2, Unit.PIXELS);
		MutableValueExpressionNode bottomExpression = new MutableValueExpressionNode(defaultLocationRange, windowDimensions.y1, Unit.PIXELS);
		MutableValueExpressionNode topExpression = new MutableValueExpressionNode(defaultLocationRange, windowDimensions.y2, Unit.PIXELS);
		
		BlockPropertyNode leftNode = new BlockPropertyNode(defaultLocationRange, RelayBlockPropertyType.left, leftExpression);
		BlockPropertyNode rightNode = new BlockPropertyNode(defaultLocationRange, RelayBlockPropertyType.right, rightExpression);
		BlockPropertyNode bottomNode = new BlockPropertyNode(defaultLocationRange, RelayBlockPropertyType.bottom, bottomExpression);
		BlockPropertyNode topNode = new BlockPropertyNode(defaultLocationRange, RelayBlockPropertyType.top, topExpression);
		
		propertyMap.put(RelayBlockPropertyType.left, leftNode);
		propertyMap.put(RelayBlockPropertyType.right, rightNode);
		propertyMap.put(RelayBlockPropertyType.bottom, bottomNode);
		propertyMap.put(RelayBlockPropertyType.top, topNode);
		
		return propertyMap;
	}

}
