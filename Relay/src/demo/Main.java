package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import relay.UILoader;
import relay.Window;
import relay.nodes.RelayNode;
import relay.nodes.RootNode;
import relay.parser.Lexer;
import relay.parser.RelayParser;
import relay.parser.symbols.RelaySymbol;
import relay.symbolTable.SymbolTable;
import relay.symbolTable.SymbolTableBuilder;
import relay.tools.TreeVisualiser;

public class Main {

	public static void main(String[] args) {
		try {
			setSwingSettings();
			File sourceFile = new File("res/testfile.rl");
			Window window = UILoader.loadUIFromFile(sourceFile);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printLexemes(File sourceFile,
			ComplexSymbolFactory factory) throws FileNotFoundException,
			IOException {
		Lexer lexer = new Lexer(new FileReader(sourceFile), factory);
		Symbol symbol = lexer.debug_next_token();
		while(symbol.sym != 0) {
			System.out.println(symbol.sym + ", " + symbol.value);
			symbol = lexer.debug_next_token();
		}
	}

	private static void dumpParseTree(RelaySymbol node, int depth) {
		for(int i = 0; i < depth; i++) {
			System.out.print("  ");
		}
		System.out.print(node);
		if(node.children.length > 0) {
			System.out.print(" (\n");
			for(int i = 0; i < node.children.length; i++) {
				if(node.children[i] != null) {
					dumpParseTree(node.children[i], depth+1);				
				} else {
					for(int j = 0; j < depth+1; j++) {
						System.out.print("  ");
					}
					System.out.print("<no children>\n");
				}
			}
			for(int i = 0; i < depth; i++) {
				System.out.print("  ");
			}
			System.out.print(")\n");			
		} else {
			System.out.print("\n");
		}
	}
	
	private static void setSwingSettings() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

}
