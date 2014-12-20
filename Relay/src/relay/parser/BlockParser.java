package relay.parser;

import relay.parser.errors.RelayParseException;
import relay.parser.struct.Block;
import relay.parser.struct.CodeBlock;
import relay.parser.struct.Property;

public class BlockParser {
	private static final char BLOCK_OPEN = '(';
	private static final char BLOCK_CLOSE = ')';
	private static int blockID = 0;

	public static Block parseBlock(FileBuffer buffer) throws RelayParseException {
		
		if(buffer.getCurrentCharacter() != BLOCK_OPEN) {
			throw new RelayParseException("Expected block open, got " + buffer.getCurrentCharacter() + ".", buffer);
		}
		
		String blockName = nextAnonymousBlockName();
		buffer.advanceToNonWhitespace();
		if(!PropertyParser.isAtProperty(buffer)) {
			blockName = readBlockName(buffer);
		}
		
		Block block = new Block(blockName);
		
		System.out.println("Block " + blockName);
		
		while(buffer.getCurrentCharacter() != BLOCK_CLOSE) {
			if(PropertyParser.isAtProperty(buffer)) {
				Property property = PropertyParser.parseProperty(buffer);
				block.addProperty(property);
			} else if(CodeBlockParser.isAtCodeBlock(buffer)) {
				CodeBlock codeBlock = CodeBlockParser.parseCodeBlock(buffer);
				block.addCodeBlock(codeBlock);
			} else if(buffer.getCurrentCharacter() == BLOCK_OPEN) {
				Block child = BlockParser.parseBlock(buffer);
				block.addChild(child);
			} else if(buffer.lookAhead(2).equals("//")) {
				buffer.advanceToNextLine();
			}
			
			buffer.advanceToNonWhitespace();
		}
		
		return block;
	}

	private static String nextAnonymousBlockName() {
		blockID++;
		return "Block_" + blockID;
	}

	private static String readBlockName(FileBuffer buffer) {
		StringBuffer nameBuffer = new StringBuffer();
		
		while(!Character.isWhitespace(buffer.getCurrentCharacter())) {
			nameBuffer.append(buffer.getCurrentCharacter());
			buffer.advanceCharacter();
		}
		return nameBuffer.toString();
	}

}
