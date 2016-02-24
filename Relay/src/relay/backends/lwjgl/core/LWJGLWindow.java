package relay.backends.lwjgl.core;

import org.lwjgl.LWJGLException;

import lib.geom.IndexRectangle2D;
import relay.Window;
import relay.backends.lwjgl.infrastructure.LWJGLBackendThread;
import relay.backends.lwjgl.rendering.RenderUtils;
import relay.layout.LayoutDefinition;

public class LWJGLWindow extends Window {

	private final LayoutDefinition layout;

	public LWJGLWindow(LayoutDefinition layout, String windowTitle, IndexRectangle2D windowDimensions) {
		super(windowTitle, windowDimensions);
		this.layout = layout;
	}

	@Override
	protected void openWindow() {
		new LWJGLBackendThread(this, title, super.dimensions).start();
	}

	@Override
	protected void closeWindow() {
		RenderUtils.destroyOpenGL();
	}

}
