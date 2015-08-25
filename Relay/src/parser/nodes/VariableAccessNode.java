package parser.nodes;

public class VariableAccessNode extends ExpressionNode {

	public final IdentifyerNode identifyer;
	public final boolean furtherAccessRemains;

	public VariableAccessNode(IdentifyerNode identifyer) {
		super(RelaySymbolType.VARIABLE_ACCESS, ExpressionType.VARIABLE_ACCESS);
		this.identifyer = identifyer;
		this.furtherAccessRemains = false;
	}

	public VariableAccessNode(IdentifyerNode identifyer, VariableAccessNode remainingAccess) {
		super(RelaySymbolType.VARIABLE_ACCESS, ExpressionType.VARIABLE_ACCESS, new RelaySymbol[]{remainingAccess});
		this.identifyer = identifyer;
		this.furtherAccessRemains = true;
	}

	@Override
	public double evaluate() {
		return 0;
	}

}
