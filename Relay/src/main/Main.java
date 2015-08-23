package main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.Symbol;
import parser.Lexer;
import parser.RelayParser;
import parser.RelaySymbols;
import parser.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			File sourceFile = new File("res/testfile.rl");
			
			ComplexSymbolFactory factory = new ComplexSymbolFactory();
			Lexer lexer = new Lexer(new FileReader(sourceFile), factory);
			System.out.println("----- PARSING START -----");
			RelayParser parser = new RelayParser(lexer, factory);
			ComplexSymbol root = (ComplexSymbol)parser.debug_parse();
			dumpParseTree(root, 0);
			System.out.println("Complete.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void dumpParseTree(ComplexSymbol node, int depth) {
		for(int i = 0; i < depth; i++) {
			System.out.print("\t");
		}
		System.out.print(node);
		System.out.print("\n");
		//for(int j = 0; j < node.)
		//dumpParseTree();
	}

}
