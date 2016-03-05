package relay.layout;

import java.util.HashMap;

import relay.exceptions.RelayException;
import relay.nodes.BlockPropertyNode;
import relay.types.RelayBlockPropertyType;

public class WindowDimensions extends BlockDimensions {

	public WindowDimensions() throws RelayException {
		super(createPropertyMap());
	}

	private static HashMap<RelayBlockPropertyType, BlockPropertyNode> createPropertyMap() {
		return null;
	}

}
