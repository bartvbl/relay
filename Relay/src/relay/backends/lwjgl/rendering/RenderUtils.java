package relay.backends.lwjgl.rendering;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import lib.geom.IndexRectangle2D;

public class RenderUtils {
	private static final int DEFAULT_WINDOW_WIDTH = 1024;
	private static final int DEFAULT_WINDOW_HEIGHT = 768;
	
	public static void newFrame()
	{
		Display.update();
		Display.sync(60);
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
		glViewport(0, 0, Display.getWidth(), Display.getHeight()); 
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
	
	public static void set2DMode()
	{
		glDisable(GL_DEPTH_TEST);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glEnable(GL_TEXTURE_2D);
		glDisable(GL_LIGHTING);
		glDisable(GL_CULL_FACE); 
	}
	
	public static void initOpenGL(String windowTitle, IndexRectangle2D windowDimensions) throws LWJGLException
	{
		Display.setTitle(windowTitle);
		Display.setLocation(windowDimensions.x1, windowDimensions.y2); // Because origin of rectangle is bottom left.
		Display.setDisplayMode(new DisplayMode(windowDimensions.width, windowDimensions.height));
		Display.setResizable(true);
		Display.create();
		
		glViewport(0, 0, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
		glClearColor(1, 1, 1, 1);
		
		RenderUtils.set2DMode();
	}

	public static void destroyOpenGL() {
		Display.destroy();
	}
}
