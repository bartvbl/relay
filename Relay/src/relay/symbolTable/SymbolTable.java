package relay.symbolTable;

import java.util.HashMap;

import relay.layout.MutableDependentValue;
import relay.util.RelayUtil;

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
		String completeIdentifyer = RelayUtil.mergeVariableAccessStrings(identifyers);
		symbols.put(completeIdentifyer, value);
	}

	@SuppressWarnings("unchecked")
	public SymbolTable copyOf() {
		return new SymbolTable((HashMap<String, MutableDependentValue>) symbols.clone());
	}

	public MutableDependentValue get(String[] identifyers) {
		return symbols.get(RelayUtil.mergeVariableAccessStrings(identifyers));
	}

	public MutableDependentValue get(String identifyer) {
		return symbols.get(identifyer);
	}

}
