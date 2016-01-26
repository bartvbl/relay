package relay.backends.lwjgl.infrastructure;

import org.lwjgl.opengl.Display;

import relay.backends.lwjgl.rendering.RenderUtils;

public class LWJGLBackendThread extends Thread {
	
	
	public void run() {
		while(!Display.isCloseRequested()) {
			RenderUtils.newFrame();
		}
	}
}
