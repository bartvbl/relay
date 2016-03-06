package relay.layout.windowRoot;

import java.awt.geom.Rectangle2D;
import java.util.HashMap;

import lib.geom.IndexRectangle2D;
import relay.data.Unit;
import relay.exceptions.RelayException;
import relay.layout.BlockDimensions;
import relay.nodes.BlockPropertyNode;
import relay.nodes.expressions.MutableValueExpressionNode;
import relay.types.RelayBlockPropertyType;

public class WindowDimensions extends BlockDimensions {

	public WindowDimensions(IndexRectangle2D windowDimensions) throws RelayException {
		super(createPropertyMap(windowDimensions));
	}

	private static HashMap<RelayBlockPropertyType, BlockPropertyNode> createPropertyMap(IndexRectangle2D windowDimensions) {
		HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap = new HashMap<RelayBlockPropertyType, BlockPropertyNode>();
		
		MutableValueExpressionNode leftExpression = new MutableValueExpressionNode(windowDimensions.x1, Unit.PIXELS);
		MutableValueExpressionNode rightExpression = new MutableValueExpressionNode(windowDimensions.x2, Unit.PIXELS);
		MutableValueExpressionNode bottomExpression = new MutableValueExpressionNode(windowDimensions.y1, Unit.PIXELS);
		MutableValueExpressionNode topExpression = new MutableValueExpressionNode(windowDimensions.y2, Unit.PIXELS);
		
		BlockPropertyNode leftNode = new BlockPropertyNode(RelayBlockPropertyType.left, leftExpression);
		BlockPropertyNode rightNode = new BlockPropertyNode(RelayBlockPropertyType.right, rightExpression);
		BlockPropertyNode bottomNode = new BlockPropertyNode(RelayBlockPropertyType.bottom, bottomExpression);
		BlockPropertyNode topNode = new BlockPropertyNode(RelayBlockPropertyType.top, topExpression);
		
		propertyMap.put(RelayBlockPropertyType.left, leftNode);
		propertyMap.put(RelayBlockPropertyType.right, rightNode);
		propertyMap.put(RelayBlockPropertyType.bottom, bottomNode);
		propertyMap.put(RelayBlockPropertyType.top, topNode);
		
		return propertyMap;
	}

}
