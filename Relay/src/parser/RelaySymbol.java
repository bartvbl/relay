package parser;

import java_cup.runtime.Symbol;

public class RelaySymbol extends Symbol {

	public final String name;
	public int line;
	public int column;

	public RelaySymbol(String name, int id, int line, int column) {
		super(id);
		this.name = name;
		this.line = line;
		this.column = column;
	}
	
	public RelaySymbol(String name, int id, int line, int column, Object value) {
		super(id);
		this.name = name;
		this.line = line;
		this.column = column;
		this.value = value;
	}

	public RelaySymbol(String name, int id, int state) {
		super(id);
		this.name = name;
	}

}
