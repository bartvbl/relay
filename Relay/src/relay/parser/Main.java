package relay.parser;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			FileBuffer buffer = FileBuffer.open(new File("res/testfile.rl"));
			RelayParser.parse(buffer);
			System.out.println("Complete.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
