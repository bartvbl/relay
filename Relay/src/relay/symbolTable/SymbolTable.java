package relay.symbolTable;

import java.util.HashMap;

import relay.layout.MutableDependentValue;

public class SymbolTable {

	private final HashMap<String, MutableDependentValue> symbols;

	public SymbolTable() {
		this.symbols = new HashMap<String, MutableDependentValue>();
	}
	
	private SymbolTable(HashMap<String, MutableDependentValue> symbols) {
		this.symbols = symbols;
	}
	
	public void put(String identifyer, MutableDependentValue value) {
		symbols.put(identifyer, value);
	}
	
	public void put(String[] identifyers, MutableDependentValue value) {
		String completeIdentifyer = mergeVariableAccessStrings(identifyers);
		symbols.put(completeIdentifyer, value);
	}

	private String mergeVariableAccessStrings(String[] identifyers) {
		StringBuilder completeIdentifyer = new StringBuilder();
		
		for(int i = 0; i < identifyers.length - 1; i++) {
			completeIdentifyer.append(identifyers[i]).append(".");
		}
		
		if(identifyers.length > 1) {
			completeIdentifyer.append(identifyers[identifyers.length - 1]);			
		}
		return completeIdentifyer.toString();
	}
	
	@SuppressWarnings("unchecked")
	public SymbolTable copyOf() {
		return new SymbolTable((HashMap<String, MutableDependentValue>) symbols.clone());
	}

	public MutableDependentValue get(String[] identifyers) {
		return symbols.get(mergeVariableAccessStrings(identifyers));
	}

	public MutableDependentValue get(String identifyer) {
		return symbols.get(identifyer);
	}

}
