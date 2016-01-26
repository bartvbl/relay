package lib.geom;

public class MutableRectangle2D {
	public double x, y;
	public double width, height;
	
	public MutableRectangle2D() {}
	
	public MutableRectangle2D(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public MutableRectangle2D(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
