package main;

import java.io.File;
import java.io.IOException;

import relay.data.Block;
import relay.parser.FileBuffer;
import relay.parser.RelayParser;
import relay.parser.errors.RelayParseException;
import relay.tools.TreeVisualiser;

public class Main {

	public static void main(String[] args) {
		try {
			FileBuffer buffer = FileBuffer.open(new File("res/testfile.rl"));
			Block root = RelayParser.parse(buffer);
			System.out.println("Complete.");
			new TreeVisualiser(root);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RelayParseException e) {
			e.printStackTrace();
		}
	}

}
