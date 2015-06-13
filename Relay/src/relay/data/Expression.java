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
		String tokenString = "";
		for(int i = 0; i < tokens.size()-1; i++) {
			tokenString += tokens.get(i);
			tokenString += " ";
		}
		tokenString += tokens.get(tokens.size()-1);
		return "[Expression: " + tokenString + "]";
	}
}
