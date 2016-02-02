package relay.symbolTable;

import java.util.HashMap;

import relay.nodes.BlockNode;

public class SymbolTable {

	private final HashMap<String, BlockNode> symbols;

	public SymbolTable(HashMap<String, BlockNode> symbols) {
		this.symbols = symbols;
	}
	
	public BlockNode getBlockByName(String name) {
		return symbols.get(name);
	}

}
