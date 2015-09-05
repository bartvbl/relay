package relay.backends.core;

import relay.layout.LayoutDefinition;

public interface Backend {
	public BackendWindow createWindow(LayoutDefinition layout);
}
