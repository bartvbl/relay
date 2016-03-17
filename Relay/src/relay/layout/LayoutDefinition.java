package relay.layout;

import lib.geom.IndexRectangle2D;
import lib.geom.Rectangle2D;
import relay.layout.windowRoot.WindowDimensions;
import relay.nodes.BlockNode;
import relay.nodes.RootNode;
import relay.nodes.expressions.MutableValueExpressionNode;
import relay.symbolTable.SymbolTable;
import relay.util.TopologicalSort;

public class LayoutDefinition {
	private final RootNode rootNode;
	private final MutableDependentValue[] linkedValues;
	private RelayDimensionNode dimensionsTreeRoot;

	public LayoutDefinition(RootNode rootNode, MutableDependentValue[] linkedValues) {
		this.rootNode = rootNode;
		this.linkedValues = linkedValues;
	}

	public void update() {
		TopologicalSort.sort(linkedValues);
		
		for(MutableDependentValue value : linkedValues) {
			value.updateCurrentValue();
		}
		
		this.dimensionsTreeRoot = buildDimensionsTree(rootNode.rootBlock);
	}
	
	private RelayDimensionNode buildDimensionsTree(BlockNode node) {
		Rectangle2D blockDimensions = node.dimensions.calculateCurrentDimensions();
		
		RelayDimensionNode[] children = new RelayDimensionNode[node.childBlocks.length];
		
		for(int i = 0; i < children.length; i++) {
			children[i] = buildDimensionsTree(node.childBlocks[i]);
		}
		
		return new RelayDimensionNode(blockDimensions, children);
	}

	public RelayDimensionNode getDimensionsTree() {
		return dimensionsTreeRoot;
	}

	public void updateWindowDimensions(IndexRectangle2D indexRectangle2D) {
		MutableValueExpressionNode leftNode = (MutableValueExpressionNode) rootNode.windowDimensions.left.expression;
		MutableValueExpressionNode rightNode = (MutableValueExpressionNode) rootNode.windowDimensions.right.expression;
		MutableValueExpressionNode bottomNode = (MutableValueExpressionNode) rootNode.windowDimensions.bottom.expression;
		MutableValueExpressionNode topNode = (MutableValueExpressionNode) rootNode.windowDimensions.top.expression;
		
		leftNode.set(0);
		rightNode.set(indexRectangle2D.width);
		bottomNode.set(0);
		topNode.set(indexRectangle2D.height);
	}
	
	
}
