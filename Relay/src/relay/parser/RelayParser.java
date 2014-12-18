package relay.parser;

import relay.parser.errors.RelayParseException;
import relay.parser.struct.Block;

public class RelayParser {

	public static Block parse(FileBuffer buffer) throws RelayParseException {
		return BlockParser.parseBlock(buffer);
	}

}
