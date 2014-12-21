package relay.data;

import java.util.ArrayList;

import relay.types.ExpressionTokenType;

public class Expression {

	private final ArrayList<ExpressionTokenType> tokenTypes;
	private final ArrayList<String> tokens;

	public Expression(ArrayList<ExpressionTokenType> tokenTypes, ArrayList<String> tokens) {
		this.tokenTypes = tokenTypes;
		this.tokens = tokens;
	}

	public double evaluate() {
		return 0;
	}
	
	public String toString() {
		return "[Expression: " + tokens + "]";
	}
}
