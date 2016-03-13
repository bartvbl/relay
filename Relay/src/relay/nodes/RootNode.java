package relay.nodes;

import java.util.ArrayList;

import lib.geom.IndexRectangle2D;
import relay.exceptions.RelayException;
import relay.layout.MutableDependentValue;
import relay.layout.windowRoot.WindowDimensions;
import relay.parser.LocationRange;
import relay.symbolTable.SymbolTable;

public class RootNode extends RelayNode {
	public final BlockNode rootBlock;
	public final WindowDimensions windowDimensions;
	public SymbolTable windowSymbolTable;

	public RootNode(LocationRange locationRange, BlockNode rootBlock, IndexRectangle2D windowDimensions) throws RelayException {
		super(locationRange, RelayNodeType.ROOT, new RelayNode[]{rootBlock});
		this.rootBlock = rootBlock;
		this.windowDimensions = new WindowDimensions(windowDimensions);
	}
	
	@Override
	public String toString() {
		return "Root node";
	}
}
