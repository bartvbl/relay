package relay.backends.core;

import relay.Window;
import relay.layout.LayoutDefinition;

public interface Backend {
	public Window createWindow(LayoutDefinition layout);
}
