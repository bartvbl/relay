package relay.renderer;

import util.Stack;

public class ExecutionContext {
	private final Stack<Scope> scopeStack = new Stack<Scope>();
}
