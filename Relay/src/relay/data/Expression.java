package relay.data;

public class Expression {
	private final String expression;

	public Expression(String expression) {
		this.expression = expression;
	}

	public double evaluate() {
		return 0;
	}
	
	public String toString() {
		return "[Expression: " + expression + "]";
	}
}
