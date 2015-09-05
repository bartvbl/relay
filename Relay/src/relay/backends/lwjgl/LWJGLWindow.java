package relay.backends.lwjgl;

import relay.backends.core.BackendWindow;
import relay.layout.LayoutDefinition;

public class LWJGLWindow implements BackendWindow {

	private final LayoutDefinition layout;

	public LWJGLWindow(LayoutDefinition layout) {
		this.layout = layout;
	}

}
