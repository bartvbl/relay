package relay.backends.core;

import lib.geom.IndexRectangle2D;
import relay.Window;
import relay.layout.LayoutDefinition;

public interface Backend {
	public Window createWindow(LayoutDefinition layout, String windowTitle, IndexRectangle2D windowDimensions);
	public void init();
}
