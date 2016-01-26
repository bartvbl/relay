package relay.backends.lwjgl.infrastructure;

import lib.geom.Dimension2D;
import lib.geom.MutableDimension2D;
import lib.geom.MutableRectangle2D;
import lib.geom.Point2D;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import relay.backends.lwjgl.core.LWJGLWindow;
import relay.backends.lwjgl.rendering.RenderUtils;
import relay.events.Event;
import relay.events.EventType;

public class LWJGLBackendThread extends Thread {
	
	private final LWJGLWindow window;
	private final String windowTitle;
	private final MutableRectangle2D windowDimensions;

	public LWJGLBackendThread(LWJGLWindow window, String windowTitle) {
		this.window = window;
		this.windowTitle = windowTitle;
		this.windowDimensions = new MutableRectangle2D();
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
		RenderUtils.initOpenGL(windowTitle);
		RenderUtils.set2DMode();
	}

	private void mainLoop() {
		while(!Display.isCloseRequested()) {
			RenderUtils.newFrame();
			updateWindowDimensions();
		}
	}

	private void updateWindowDimensions() {
		double windowWidth = Display.getWidth();
		double windowHeight = Display.getHeight();
		double windowX = Display.getX();
		double windowY = Display.getY();
		
		if(windowDimensions.width != windowWidth || windowDimensions.height != windowHeight) {
			Dimension2D newWindowDimensions = new Dimension2D(windowWidth, windowHeight);
			window.eventDispatcher.dispatchEvent(new Event<Dimension2D>(EventType.WINDOW_RESIZED, newWindowDimensions));
		}
		
		if(windowDimensions.x != windowX || windowDimensions.y != windowY) {
			Point2D newWindowLocation = new Point2D(windowX, windowY);
			window.eventDispatcher.dispatchEvent(new Event<Point2D>(EventType.WINDOW_MOVED, newWindowLocation));
		}
		
		this.windowDimensions.setLocation(windowX, windowY);
		this.windowDimensions.setDimensions(windowWidth, windowHeight);
	}
}
