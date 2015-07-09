package parser;

import java_cup.runtime.Symbol;

public class RelaySymbol extends Symbol {

	public final String name;

	public RelaySymbol(String name, int id, int state) {
		super(id);
		this.name = name;
	}

}
