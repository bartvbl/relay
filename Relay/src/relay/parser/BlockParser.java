package relay.parser;

import relay.parser.errors.RelayParseException;
import relay.parser.struct.Block;
import relay.parser.struct.Property;

public class BlockParser {
	private static final char BLOCK_OPEN = '(';
	private static final char BLOCK_CLOSE = ')';

	public static Block parseBlock(FileBuffer buffer) throws RelayParseException {
		System.out.println("Blocks");
		
		if(buffer.getCurrentCharacter() != BLOCK_OPEN) {
			throw new RelayParseException("Expected block open, got " + buffer.getCurrentCharacter() + ".", buffer);
		}
		
		buffer.advanceCharacter();
		
		Block block = new Block();
		
		while(buffer.getCurrentCharacter() != BLOCK_CLOSE) {
			if(PropertyParser.isAtProperty(buffer)) {
				Property property = PropertyParser.parseProperty(buffer);
				block.addProperty(property);
			}
			if(buffer.getCurrentCharacter() == BLOCK_OPEN) {
				Block child = BlockParser.parseBlock(buffer);
				block.addChild(child);
			}
			if(buffer.lookAhead(2).equals("//")) {
				buffer.advanceToNextLine();
			}
			
			buffer.advanceToNonWhitespace();
		}
		
		return block;
	}

}
