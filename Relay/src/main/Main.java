package main;

import java.io.File;
import java.io.IOException;

import java_cup.runtime.Scanner;
import parser.RelayParser;
import relay.data.Block;
import relay.parser.FileBuffer;
import relay.parser.RelaySymbolFactory;
import relay.parser.errors.RelayParseException;
import relay.renderer.TreeRenderer;
import relay.tools.TreeVisualiser;

public class Main {

	public static void main(String[] args) {
		try {
			File sourceFile = new File("res/testfile.rl");
			System.out.println("Complete.");
			
			RelaySymbolFactory symbolFactory = new RelaySymbolFactory();
			RelayParser parser = new RelayParser(scanner, symbolFactory);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RelayParseException e) {
			e.printStackTrace();
		}
	}

}
