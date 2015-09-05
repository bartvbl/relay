package relay.backends.lwjgl;

import relay.backends.core.Backend;
import relay.backends.core.BackendWindow;
import relay.layout.LayoutDefinition;

public class LWJGLBackend implements Backend {

	private int openedWindows = 0;
	
	@Override
	public BackendWindow createWindow(LayoutDefinition layout) {
		if(openedWindows == 0) {
			openedWindows++;
			return new LWJGLWindow(layout);			
		}
		throw new RuntimeException("LWJGL backend only supports one window.");
	}


}
