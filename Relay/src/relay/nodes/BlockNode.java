package relay.nodes;

import java.util.HashMap;

import relay.layout.BlockDimensions;

public class BlockNode extends RelayNode {
	public final String name;
	
	public final BlockNode[] childBlocks;
	public final CodeBlockNode[] childCodeBlocks;
	
	public final BlockDimensions dimensions;
	private final HashMap<String, BlockPropertyNode> propertyMap;

	public BlockNode(
			String blockName, 
			RelayNode[] childNodes, 
			BlockNode[] childBlocks, 
			CodeBlockNode[] childCodeBlocks, 
			HashMap<String, BlockPropertyNode> propertyMap,
			BlockDimensions dimensions
		) {
		
		super(RelayNodeType.BLOCK, childNodes);
		this.name = blockName;
		this.childBlocks = childBlocks;
		this.childCodeBlocks = childCodeBlocks;
		
		this.propertyMap = propertyMap;
		this.dimensions = dimensions;
	}

	@Override
	public String toString() {
		return "Block named \"" + name + "\"";
	}
}
