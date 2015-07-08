package parser;

import java_cup.runtime.Symbol;

public class JavaSymbol extends Symbol {
	
	private int line;
	private int column;
	private int type;
	private Object value;

	public JavaSymbol(int type, int line, int column) {
		super(type, line, column);
		this.line = line;
		this.column = column;
		this.type = type;
	}
	
	public JavaSymbol(int type, int line, int column, Object value) {
		super(type, line, column, value);
		this.line = line;
		this.column = column;
		this.type = type;
		this.value = value;
	}

}
