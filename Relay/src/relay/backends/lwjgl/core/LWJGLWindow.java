package relay.backends.lwjgl.core;

import relay.Window;
import relay.layout.LayoutDefinition;

public class LWJGLWindow implements Window {

	private final LayoutDefinition layout;

	public LWJGLWindow(LayoutDefinition layout) {
		this.layout = layout;
	}

	@Override
	public void open() {
		
	}

	@Override
	public void close() {
		
	}

}
