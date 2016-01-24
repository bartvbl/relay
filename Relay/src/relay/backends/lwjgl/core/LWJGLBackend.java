package relay.backends.lwjgl.core;

import relay.Window;
import relay.backends.core.Backend;
import relay.layout.LayoutDefinition;

public class LWJGLBackend implements Backend {

	private int openedWindows = 0;
	
	@Override
	public Window createWindow(LayoutDefinition layout) {
		if(openedWindows == 0) {
			openedWindows++;
			return new LWJGLWindow(layout);			
		}
		throw new RuntimeException("LWJGL backend only supports one window.");
	}

	public static Backend create() {
		return new LWJGLBackend();
	}


}
