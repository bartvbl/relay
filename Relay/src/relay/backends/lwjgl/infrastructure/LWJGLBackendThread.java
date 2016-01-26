package relay.backends.lwjgl.infrastructure;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import relay.backends.lwjgl.core.LWJGLWindow;
import relay.backends.lwjgl.rendering.RenderUtils;

public class LWJGLBackendThread extends Thread {
	
	private final LWJGLWindow window;
	private final String windowTitle;

	public LWJGLBackendThread(LWJGLWindow window, String windowTitle) {
		this.window = window;
		this.windowTitle = windowTitle;
	}

	public void run() {
		try {
			init();
			mainLoop();
		} catch (LWJGLException e) {
			e.printStackTrace();
			window.close();
		}
	}

	private void init() throws LWJGLException {
		RenderUtils.initOpenGL(windowTitle);
		RenderUtils.set2DMode();
	}

	private void mainLoop() {
		while(!Display.isCloseRequested()) {
			RenderUtils.newFrame();
		}
	}
}
