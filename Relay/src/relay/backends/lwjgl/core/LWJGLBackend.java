package relay.backends.lwjgl.core;

import lib.geom.IndexRectangle2D;
import relay.Window;
import relay.backends.core.Backend;
import relay.layout.LayoutDefinition;

public class LWJGLBackend implements Backend {

	private static int openedWindows = 0;
	
	@Override
	public Window createWindow(LayoutDefinition layout, String windowTitle, IndexRectangle2D windowDimensions) {
		if(openedWindows == 0) {
			openedWindows++;
			return new LWJGLWindow(layout, windowTitle, windowDimensions);			
		}
		throw new RuntimeException("LWJGL backend only supports one window.");
	}

	public static Backend create() {
		return new LWJGLBackend();
	}
	
	public void init() {
		
	}
}
