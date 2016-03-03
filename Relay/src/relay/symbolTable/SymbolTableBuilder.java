package relay.symbolTable;

import relay.nodes.BlockNode;
import relay.nodes.RootNode;
import relay.parser.symbols.types.ReservedKeyword;

public class SymbolTableBuilder {

	public static void buildSymbolTable(RootNode rootNode) {
		SymbolTable rootTable = new SymbolTable();
		rootTable.putBlockSymbol(ReservedKeyword.parent.name(), null);
		visit(rootNode.rootBlock, rootTable);
	}

	private static void visit(BlockNode block, SymbolTable symbolTable) {
		symbolTable.putBlockSymbol(block);
		block.setSymbolTable(symbolTable);
		
		for(BlockNode child : block.childBlocks) {	
			SymbolTable childTable = symbolTable.copyOf();
			childTable.putBlockSymbol(ReservedKeyword.parent.name(), block);
			
			visit(child, childTable);
		}
	}

}
