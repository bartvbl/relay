package relay.layout;

import relay.nodes.RootNode;
import relay.util.TopologicalSort;

public class LayoutDefinitionBuilder {

	public static LayoutDefinition createFromParseTree(RootNode rootNode, MutableDependentValue[] linkedValues) {
		LayoutDefinition definition = new LayoutDefinition(rootNode, linkedValues);
		definition.update();

		return definition;
	}

}
