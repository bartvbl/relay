package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import parser.Lexer;
import parser.RelayParser;
import parser.symbols.RelaySymbol;
import relay.nodes.RelayNode;

public class Main {

	public static void main(String[] args) {
		try {
			File sourceFile = new File("res/testfile.rl");

			ComplexSymbolFactory factory = new ComplexSymbolFactory();
			Lexer lexer;
			//printLexemes(sourceFile, factory);
			lexer = new Lexer(new FileReader(sourceFile), factory);
			System.out.println("----- PARSING START -----");
			RelayParser parser = new RelayParser(lexer, factory);
			RelaySymbol root = (RelaySymbol)parser.parse().value;
			dumpParseTree(root, 0);
			RelayNode rootNode = root.compact();
			System.out.println("Complete.");
		} catch (IOException e) {
			e.printStackTrace();
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

}
