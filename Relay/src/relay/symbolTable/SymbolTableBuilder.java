package relay.symbolTable;

import relay.nodes.BlockNode;
import relay.nodes.RootNode;
import relay.parser.symbols.types.ReservedKeyword;

public class SymbolTableBuilder {

	public static void createLocalSymbolTables(RootNode rootNode) {
		// As all blocks are in global scope, we first collect all of them in a single table
		SymbolTable globalTable = buildGlobalSymbolTable(rootNode);
		
		// second iteration to include the "parent" keyword into the symbol table. Now any block will have this entry as well as the complete symbol table.
		globalTable.putBlockSymbol(ReservedKeyword.parent.name(), null);
		visitLocal(rootNode.rootBlock, globalTable);
	}
	
	private static void visitLocal(BlockNode block, SymbolTable symbolTable) {
		block.setSymbolTable(symbolTable);
		
		for(BlockNode child : block.childBlocks) {	
			SymbolTable childTable = symbolTable.copyOf();
			childTable.putBlockSymbol(ReservedKeyword.parent.name(), block);
			
			visitLocal(child, childTable);
		}
	}
	
	public static SymbolTable buildGlobalSymbolTable(RootNode rootNode) {
		SymbolTable table = new SymbolTable();
		visitGlobal(rootNode.rootBlock, table);
		return table;
	}

	private static void visitGlobal(BlockNode block, SymbolTable table) {
		table.putBlockSymbol(block);
		
		for(BlockNode child : block.childBlocks) {	
			visitLocal(child, table);
		}
	}

}
