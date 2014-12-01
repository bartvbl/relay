package relay.parser;

import relay.parser.struct.Block;

public class RelayParser {

	public static void parse(FileBuffer buffer) {
		Block block = BlockParser.parseBlock(buffer);
	}

}
