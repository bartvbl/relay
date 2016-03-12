package relay.nodes;

import java.util.HashMap;

import relay.layout.BlockDimensions;
import relay.parser.LocationRange;
import relay.symbolTable.SymbolTable;
import relay.types.BlockType;
import relay.types.RelayBlockPropertyType;

public class BlockNode extends RelayNode {
	public final String name;
	public final BlockType blockType;
	
	public final BlockNode[] childBlocks;
	public final CodeBlockNode[] childCodeBlocks;
	public final VariableDefinitionNode[] variableDefinitions;
	
	public final BlockDimensions dimensions;
	
	private final HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap;

	public SymbolTable symbolTable;



	public BlockNode(
			LocationRange locationRange,
			String blockName, 
			BlockType blockType, 
			RelayNode[] childNodes, 
			BlockNode[] childBlocks, 
			CodeBlockNode[] childCodeBlocks, 
			VariableDefinitionNode[] variableDefinitions, 
			HashMap<RelayBlockPropertyType, BlockPropertyNode> propertyMap,
			BlockDimensions dimensions
		) {
		
		super(locationRange, RelayNodeType.BLOCK, childNodes);
		
		this.name = blockName;
		this.blockType = blockType;
		this.childBlocks = childBlocks;
		this.childCodeBlocks = childCodeBlocks;
		this.variableDefinitions = variableDefinitions;
		
		this.propertyMap = propertyMap;
		this.dimensions = dimensions;
	}

	@Override
	public String toString() {
		return "Block named \"" + name + "\"";
	}

	public void setSymbolTable(SymbolTable symbolTable) {
		this.symbolTable = symbolTable;
	}
}
