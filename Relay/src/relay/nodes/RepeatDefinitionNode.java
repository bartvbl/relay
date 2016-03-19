package relay.nodes;

import relay.nodes.expressions.VariableAccessNode;
import relay.parser.LocationRange;

public class RepeatDefinitionNode extends RelayNode {

	public final String identifyer;
	public final VariableAccessNode variableAccess;
	public final BlockNode blockNode;

	public RepeatDefinitionNode(LocationRange location, String identifyer, VariableAccessNode variableAccess, BlockNode blockNode) {
		super(location, RelayNodeType.REPEAT_DEFINITION, new RelayNode[]{variableAccess, blockNode});
		
		this.identifyer = identifyer;
		this.variableAccess = variableAccess;
		this.blockNode = blockNode;
	}

}
