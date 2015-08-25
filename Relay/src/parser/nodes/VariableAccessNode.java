package parser.nodes;

public class VariableAccessNode extends ExpressionNode {

	public final IdentifyerNode identifyer;
	public final boolean furtherAccessRemains;

	public VariableAccessNode(IdentifyerNode identifyer) {
		super(RelaySymbolType.VARIABLE_ACCESS, ExpressionType.VARIABLE_ACCESS, new RelaySymbol[]{identifyer});
		this.identifyer = identifyer;
		this.furtherAccessRemains = false;
	}

	public VariableAccessNode(IdentifyerNode identifyer, VariableAccessNode remainingAccess) {
		super(RelaySymbolType.VARIABLE_ACCESS, ExpressionType.VARIABLE_ACCESS, new RelaySymbol[]{identifyer, remainingAccess});
		this.identifyer = identifyer;
		this.furtherAccessRemains = true;
	}

	@Override
	public double evaluate() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Variable access node";
	}

}
