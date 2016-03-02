package relay.backends.lwjgl.infrastructure;

import lib.geom.Dimension2D;
import lib.geom.Index2D;
import lib.geom.IndexRectangle2D;
import lib.geom.MutableDimension2D;
import lib.geom.MutableRectangle2D;
import lib.geom.Point2D;

import java.util.concurrent.atomic.AtomicReference;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import relay.backends.lwjgl.core.LWJGLWindow;
import relay.backends.lwjgl.rendering.RenderUtils;
import relay.events.Event;
import relay.events.EventType;

public class LWJGLBackendThread extends Thread {
	
	private final LWJGLWindow window;
	private final String windowTitle;
	private final AtomicReference<IndexRectangle2D> windowDimensions;

	public LWJGLBackendThread(LWJGLWindow window, String windowTitle, IndexRectangle2D dimensions) {
		this.window = window;
		this.windowTitle = windowTitle;
		this.windowDimensions = new AtomicReference<IndexRectangle2D>();
		windowDimensions.set(dimensions);
	}

	public void run() {
		try {
			init();
			mainLoop();
			window.close();
		} catch (LWJGLException e) {
			e.printStackTrace();
			window.close();
		}
	}

	private void init() throws LWJGLException {
		RenderUtils.initOpenGL(windowTitle, windowDimensions.get());
		RenderUtils.set2DMode();
	}

	private void mainLoop() {
		while(!Display.isCloseRequested()) {
			RenderUtils.newFrame();
			updateWindowDimensions();
		}
	}

	private void updateWindowDimensions() {
		int windowWidth = Display.getWidth();
		int windowHeight = Display.getHeight();
		int windowX = Display.getX();
		int windowY = Display.getY();
		
		IndexRectangle2D previousDimensions = windowDimensions.get();
		
		if(previousDimensions.width != windowWidth || previousDimensions.height != windowHeight) {
			Dimension2D newWindowDimensions = new Dimension2D(windowWidth, windowHeight);
			window.events.dispatchEvent(new Event<Dimension2D>(EventType.WINDOW_RESIZED, newWindowDimensions));
		}
		
		if(previousDimensions.x1 != windowX || previousDimensions.y2 != windowY) { // Different because the origin of the rectangle is in the bottom left.
			Index2D newWindowLocation = new Index2D(windowX, windowY);
			window.events.dispatchEvent(new Event<Index2D>(EventType.WINDOW_MOVED, newWindowLocation));
		}
		
		this.windowDimensions.set(new IndexRectangle2D(windowX, windowY, windowWidth, windowHeight));
	}
}
