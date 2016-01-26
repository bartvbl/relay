package lib.geom;

public class Rectangle2D {
	public final int x1;
	public final int y1;
	public final int x2;
	public final int y2;
	public final int width;
	public final int height;
	
	public Rectangle2D(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.width = x2 - x1;
		this.height = y2 - y1;
	}
	
	public String toString() {
		return "Rectangle (" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")";
	}

	public boolean intersects(Rectangle2D other) {
		return !(this.x1 > other.x2 || this.x2 < other.x1 || this.y1 > other.y2 || this.y2 < other.y1);
	}

	public Rectangle2D expandToInclude(Rectangle2D other) {
		return new Rectangle2D(
			Math.min(this.x1, other.x1),
			Math.min(this.y1, other.y1),
			Math.max(this.x2, other.x2),
			Math.max(this.y2, other.y2)
		);
	}
	
	public boolean equals(Rectangle2D other) {
		return 
			this.x1 == other.x1 &&
			this.x2 == other.x2 &&
			this.y1 == other.y1 &&
			this.y2 == other.y2;
	}
}
