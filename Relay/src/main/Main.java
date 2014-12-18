package main;

import java.io.File;
import java.io.IOException;

import relay.parser.FileBuffer;
import relay.parser.RelayParser;
import relay.parser.errors.RelayParseException;

public class Main {

	public static void main(String[] args) {
		try {
			FileBuffer buffer = FileBuffer.open(new File("res/testfile.rl"));
			RelayParser.parse(buffer);
			System.out.println("Complete.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RelayParseException e) {
			e.printStackTrace();
		}
	}

}
