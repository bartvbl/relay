package lib.geom;

public class MutableDimension2D {

	public double width, height;
	
	public MutableDimension2D(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public MutableDimension2D() {}

	public String toString() {
		return "MutableDimension2D of size [" + width + ", " + height + "]";
	}
}
