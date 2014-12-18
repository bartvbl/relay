package relay.parser;

import relay.parser.struct.Block;

public class RelayParser {

	public static Block parse(FileBuffer buffer) {
		return BlockParser.parseBlock(buffer);
	}

}
