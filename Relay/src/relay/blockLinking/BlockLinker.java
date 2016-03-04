package relay.blockLinking;

import relay.nodes.BlockNode;
import relay.nodes.RootNode;

public class BlockLinker {

	public static void linkBlockExpressions(RootNode rootNode) {
		visit(rootNode.rootBlock);
	}

	private static void visit(BlockNode block) {
		
	}

}
