package relay.types;

public enum ExpressionTokenType {
	ARGUMENT_LIST_OPEN(new char[]{'('}),
	ARGUMENT_LIST_CLOSE(new char[]{')'}),
	DOT(new char[]{'.'}),
	IDENTIFYER(new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','_'}),
	OPERATOR(new char[]{'+', '-', '*', '/'});
	
	private ExpressionTokenType(char[] applicableCharacters) {
		
	}
}
