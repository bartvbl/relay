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
import relay.layout.RelayDimensionNode;

import static org.lwjgl.opengl.GL11.*;

public class LWJGLBackendThread extends Thread {
	
	private final LWJGLWindow window;
	private final String windowTitle;

	public LWJGLBackendThread(LWJGLWindow window, String windowTitle, IndexRectangle2D dimensions) {
		this.window = window;
		this.windowTitle = windowTitle;
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
		RenderUtils.initOpenGL(windowTitle, window.getDimensions());
		RenderUtils.set2DMode();
	}

	private void mainLoop() {
		while(!Display.isCloseRequested()) {
			RenderUtils.newFrame();
			window.updateDimensions();
			window.layout.update();
			RelayDimensionNode dimensions = window.layout.getDimensionsTree();
			renderRectangle(dimensions, 0);
		}
	}

	private int renderRectangle(RelayDimensionNode dimensions, int id) {
		double colour = ((double) ((70 * id) % 255)) / 255d;
		glColor4d(colour, colour, colour, 1);
		glBegin(GL_QUADS);
		glVertex2d(dimensions.size.x1, dimensions.size.y1);
		glVertex2d(dimensions.size.x2, dimensions.size.y1);
		glVertex2d(dimensions.size.x2, dimensions.size.y2);
		glVertex2d(dimensions.size.x1, dimensions.size.y2);
		glEnd();
		
		for(RelayDimensionNode child : dimensions.children) {
			id = renderRectangle(child, id + 1);
		}
		return id;
	}

	
}
