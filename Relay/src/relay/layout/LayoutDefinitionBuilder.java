package relay.layout;

import relay.nodes.RootNode;
import relay.util.TopologicalSort;

public class LayoutDefinitionBuilder {

	public static LayoutDefinition createFromParseTree(RootNode rootNode, MutableDependentValue[] linkedValues) {
		TopologicalSort.sort(linkedValues);
		return null;
	}

}
