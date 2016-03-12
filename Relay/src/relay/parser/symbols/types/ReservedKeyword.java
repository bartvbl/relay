package relay.parser.symbols.types;
// No real need to have these in an enum, but it provides an overview of which keywords exist, and allows searching the code for locations where they are used.
public enum ReservedKeyword {
	parent("parent"),
	content("content"),
	def("def"), 
	keyword_this("__RELAY_INTERNAL_KEYWORD_THIS_NODE");
	
	public final String name;

	private ReservedKeyword(String name) {
		this.name = name;
	}
}
