package relay.symbolTable;

import java.util.HashMap;

import relay.nodes.BlockNode;

public class SymbolTable {

	private final HashMap<String, BlockNode> blockSymbols;

	public SymbolTable() {
		this.blockSymbols = new HashMap<String, BlockNode>();
	}
	
	private SymbolTable(HashMap<String, BlockNode> symbols) {
		this.blockSymbols = symbols;
	}
	
	public void putBlockSymbol(String name, BlockNode blockSymbol) {
		this.blockSymbols.put(name, blockSymbol);
	}

	public void putBlockSymbol(BlockNode block) {
		this.blockSymbols.put(block.name, block);
	}

	public BlockNode getBlockByName(String name) {
		return blockSymbols.get(name);
	}
	
	@SuppressWarnings("unchecked")
	public SymbolTable copyOf() {
		return new SymbolTable((HashMap<String, BlockNode>)blockSymbols.clone());
	}


}
