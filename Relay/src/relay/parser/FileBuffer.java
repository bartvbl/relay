package relay.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileBuffer {
	private final String fileContents;
	private int charPointer = 0;

	private FileBuffer(String fileContents) {
		this.fileContents = fileContents;
	}
	
	public char getCurrentCharacter() {
		return fileContents.charAt(charPointer);
	}
	
	public String lookAhead(int characterCount) {
		int end = Math.min(charPointer + characterCount, fileContents.length());
		return fileContents.substring(charPointer, end);
	}
	
	public void advanceToNonWhitespace() {
		while(charPointer < fileContents.length() - 1) {
			charPointer++;
			char currentCharacter = fileContents.charAt(charPointer);
			if(!Character.isWhitespace(currentCharacter)) {
				return;
			}
		}
	}
	
	public void advanceCharacter() {
		if(charPointer < fileContents.length() - 1) {
			charPointer++;
		}
	}
	
	public boolean isAtEnd() {
		return charPointer == fileContents.length() - 1;
	}
	
	public static FileBuffer open(File file) throws IOException {
		FileInputStream stream = new FileInputStream(file);
		byte[] fileContents = new byte[(int) file.length()];
		stream.read(fileContents);
		stream.close();
		return new FileBuffer(new String(fileContents));
	}

	public void advanceMultipleCharacters(int length) {
		charPointer = Math.min(charPointer + length, fileContents.length() - 1);
	}
}
