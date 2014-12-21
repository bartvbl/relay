package relay.parser;

import relay.data.Block;
import relay.parser.errors.RelayParseException;

public class RelayParser {

	public static Block parse(FileBuffer buffer) throws RelayParseException {
		return BlockParser.parseBlock(buffer);
	}

}
