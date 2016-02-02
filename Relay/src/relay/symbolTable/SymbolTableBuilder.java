package relay.symbolTable;

import java.util.HashMap;

import relay.nodes.BlockNode;
import relay.nodes.RootNode;

public class SymbolTableBuilder {

	public static SymbolTable buildSymbolTable(RootNode rootNode) {
		HashMap<String, BlockNode> symbols = new HashMap<String, BlockNode>();
		visit(rootNode.rootBlock, symbols);
		
		return new SymbolTable(symbols);
	}

	private static void visit(BlockNode block, HashMap<String, BlockNode> symbols) {
		if(symbols.containsKey(block.name)) {
			
		}
		
		symbols.put(block.name, block);
		for(BlockNode child : block.childBlocks) {
			visit(child, symbols);
		}
	}

}
