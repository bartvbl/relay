package lib.geom;

public class Rectangle2D {
	public final double x1;
	public final double y1;
	public final double x2;
	public final double y2;
	public final double width;
	public final double height;
	
	public Rectangle2D(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.width = x2 - x1;
		this.height = y2 - y1;
	}
	
	public String toString() {
		return "Rectangle located at [" + x1 + ", " + y1 + "] of size [" + width + ", " + height + "]";
	}

	public boolean intersects(Rectangle2D other) {
		return !(this.x1 > other.x2 || this.x2 < other.x1 || this.y1 > other.y2 || this.y2 < other.y1);
	}

	public boolean equals(Rectangle2D other) {
		return 
			this.x1 == other.x1 &&
			this.x2 == other.x2 &&
			this.y1 == other.y1 &&
			this.y2 == other.y2;
	}
}
