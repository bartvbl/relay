package relay.backends.lwjgl.core;

import org.lwjgl.LWJGLException;

import relay.Window;
import relay.backends.lwjgl.rendering.RenderUtils;
import relay.layout.LayoutDefinition;

public class LWJGLWindow extends Window {

	private final LayoutDefinition layout;

	public LWJGLWindow(LayoutDefinition layout) {
		this.layout = layout;
	}

	@Override
	protected void openWindow() {
		try {
			RenderUtils.initOpenGL("Relay Window");
			RenderUtils.set2DMode();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void closeWindow() {
		RenderUtils.destroyOpenGL();
	}

}
