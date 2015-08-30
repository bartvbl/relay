package relay;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java_cup.runtime.ComplexSymbolFactory;
import relay.nodes.RootNode;
import relay.parser.Lexer;
import relay.parser.RelayParser;
import relay.parser.symbols.RelaySymbol;
import relay.symbolTable.SymbolTable;
import relay.symbolTable.SymbolTableBuilder;
import relay.tools.TreeVisualiser;

public class UILoader {
	public static Window loadUIFromFile(File source) throws Exception {
		ComplexSymbolFactory factory = new ComplexSymbolFactory();
		Lexer lexer;
		//printLexemes(sourceFile, factory);
		lexer = new Lexer(new FileReader(source), factory);
		relay.parser.RelayParser parser = new RelayParser(lexer, factory);
		RelaySymbol root = (RelaySymbol)parser.parse().value;
		//dumpParseTree(root, 0);
		RootNode rootNode = (RootNode) root.compact();
		SymbolTable symbolTable = SymbolTableBuilder.buildSymbolTable(rootNode);
		
		
		new TreeVisualiser(rootNode);
		System.out.println("Complete.");
		return new Window(rootNode);
	}
}
