package relay.backends.lwjgl.core;

import java.util.concurrent.atomic.AtomicReference;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import lib.geom.Dimension2D;
import lib.geom.Index2D;
import lib.geom.IndexRectangle2D;
import relay.Window;
import relay.backends.lwjgl.infrastructure.LWJGLBackendThread;
import relay.backends.lwjgl.rendering.RenderUtils;
import relay.events.Event;
import relay.events.EventType;
import relay.layout.LayoutDefinition;

public class LWJGLWindow extends Window {

	public final LayoutDefinition layout;
	private final AtomicReference<IndexRectangle2D> windowDimensions;

	public LWJGLWindow(LayoutDefinition layout, String windowTitle, IndexRectangle2D windowDimensions) {
		super(windowTitle, windowDimensions);
		this.layout = layout;
		this.windowDimensions = new AtomicReference<IndexRectangle2D>();
		this.windowDimensions.set(dimensions);
	}

	@Override
	protected void openWindow() {
		new LWJGLBackendThread(this, title, super.dimensions).start();
	}

	@Override
	protected void closeWindow() {
		RenderUtils.destroyOpenGL();
	}

	public void updateDimensions() {
		int windowWidth = Display.getWidth();
		int windowHeight = Display.getHeight();
		int windowX = Display.getX();
		int windowY = Display.getY();
		
		IndexRectangle2D previousDimensions = windowDimensions.get();
		
		if(previousDimensions.width != windowWidth || previousDimensions.height != windowHeight) {
			Dimension2D newWindowDimensions = new Dimension2D(windowWidth, windowHeight);
			events.dispatchEvent(new Event<Dimension2D>(EventType.WINDOW_RESIZED, newWindowDimensions));
		}
		
		if(previousDimensions.x1 != windowX || previousDimensions.y2 != windowY) { // Different because the origin of the rectangle is in the bottom left.
			Index2D newWindowLocation = new Index2D(windowX, windowY);
			events.dispatchEvent(new Event<Index2D>(EventType.WINDOW_MOVED, newWindowLocation));
		}

		this.windowDimensions.set(new IndexRectangle2D(windowX, windowY, windowX + windowWidth, windowY + windowHeight));
		
		layout.updateWindowDimensions(windowDimensions.get());
	}

	public IndexRectangle2D getDimensions() {
		return windowDimensions.get();
	}

}
