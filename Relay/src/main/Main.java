package main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java_cup.runtime.Symbol;
import parser.RelayParser;
import parser.Scanner;
import relay.parser.RelaySymbolFactory;
import relay.parser.errors.RelayParseException;

public class Main {

	public static void main(String[] args) {
		try {
			File sourceFile = new File("res/testfile.rl");
			
			Scanner scanner = new Scanner(new FileReader(sourceFile));
			RelaySymbolFactory symbolFactory = new RelaySymbolFactory();
			RelayParser parser = new RelayParser(scanner, symbolFactory);
			Symbol symbol = parser.debug_parse();
			System.out.println("Complete.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
