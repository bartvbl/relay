package parser;

import java_cup.runtime.Symbol;

public class RelaySymbol extends Symbol {

	public final String name;
	public final int line;
	public final int column;

	public RelaySymbol(int symbolID, String name, int line, int column) {
		super(symbolID);
		this.name = name;
		this.line = line;
		this.column = column;
	}

}
