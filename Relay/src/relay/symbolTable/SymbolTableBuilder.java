package relay.symbolTable;

import relay.layout.BlockDimensions;
import relay.nodes.BlockNode;
import relay.nodes.RootNode;
import relay.nodes.VariableDefinitionNode;
import relay.parser.symbols.types.ReservedKeyword;
import relay.types.RelayBlockPropertyType;

public class SymbolTableBuilder {

	public static void createLocalSymbolTables(RootNode rootNode) {
		// As all blocks are in global scope, we first collect all of them in a single table
		SymbolTable globalTable = buildGlobalSymbolTable(rootNode);
		
		// second iteration to include the "parent" keyword into the symbol table. Now any block will have this entry as well as the complete symbol table.
		putBlockSymbols(ReservedKeyword.parent.name(), rootNode.windowDimensions, globalTable);
		visitLocal(rootNode.rootBlock, globalTable);
	}
	
	private static void visitLocal(BlockNode block, SymbolTable symbolTable) {
		block.setSymbolTable(symbolTable);
		
		for(BlockNode child : block.childBlocks) {	
			SymbolTable childTable = symbolTable.copyOf();
			
			putBlockSymbols(ReservedKeyword.parent.name(), block.dimensions, childTable);
			putVariableDefintiions(block.variableDefinitions, childTable);
			
			visitLocal(child, childTable);
		}
	}

	public static SymbolTable buildGlobalSymbolTable(RootNode rootNode) {
		SymbolTable table = new SymbolTable();
		visitGlobal(rootNode.rootBlock, table);
		return table;
	}

	private static void visitGlobal(BlockNode block, SymbolTable table) {
		putBlockSymbols(block.name, block.dimensions, table);
		
		for(BlockNode child : block.childBlocks) {	
			visitGlobal(child, table);
		}
	}

	private static void putBlockSymbols(String baseName, BlockDimensions dimensions, SymbolTable table) {
		table.put(new String[]{baseName, RelayBlockPropertyType.left.name()}, dimensions.left);
		table.put(new String[]{baseName, RelayBlockPropertyType.right.name()}, dimensions.right);
		table.put(new String[]{baseName, RelayBlockPropertyType.width.name()}, dimensions.width);
		
		table.put(new String[]{baseName, RelayBlockPropertyType.top.name()}, dimensions.top);
		table.put(new String[]{baseName, RelayBlockPropertyType.bottom.name()}, dimensions.bottom);
		table.put(new String[]{baseName, RelayBlockPropertyType.height.name()}, dimensions.height);
	}
	
	private static void putVariableDefintiions(VariableDefinitionNode[] variableDefinitions, SymbolTable childTable) {
		for(VariableDefinitionNode definition : variableDefinitions) {
			childTable.put(definition.identifier, definition);
		}
	}

}
