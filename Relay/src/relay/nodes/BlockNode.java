package relay.nodes;

import java.util.HashMap;

import relay.layout.BlockDimensions;

public class BlockNode extends RelayNode {
	public final String name;
	
	public final BlockNode[] childBlocks;
	public final CodeBlockNode[] childCodeBlocks;
	public final BlockPropertyNode[] blockProperties;
	
	public final BlockDimensions dimensions;

	public BlockNode(String blockName, RelayNode[] childNodes, BlockNode[] childBlocks, CodeBlockNode[] childCodeBlocks, BlockPropertyNode[] blockProperties) {
		super(RelayNodeType.BLOCK, childNodes);
		this.name = blockName;
		this.childBlocks = childBlocks;
		this.childCodeBlocks = childCodeBlocks;
		this.blockProperties = blockProperties;
		
		HashMap<String, BlockPropertyNode> propertyMap = new HashMap<String, BlockPropertyNode>();
		for(BlockPropertyNode property : blockProperties) {
			propertyMap.put(property.identifyer, property);
		}
		
		try {
			this.dimensions = new BlockDimensions(propertyMap);			
		} catch (RuntimeException e) {
			throw new RuntimeException("Semantics error in block \"" + name + "\"", e);
		}
	}
	
	@Override
	public String toString() {
		return "Block named \"" + name + "\"";
	}
}
