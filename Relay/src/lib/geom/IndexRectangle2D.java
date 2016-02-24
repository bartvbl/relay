package lib.geom;

public class IndexRectangle2D {
	public final int x1;
	public final int y1;
	public final int x2;
	public final int y2;
	public final int width;
	public final int height;
	
	public IndexRectangle2D(int x1, int y1, int x2, int y2) {
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

	public boolean intersects(IndexRectangle2D other) {
		return !(this.x1 > other.x2 || this.x2 < other.x1 || this.y1 > other.y2 || this.y2 < other.y1);
	}

	public IndexRectangle2D expandToInclude(IndexRectangle2D other) {
		return new IndexRectangle2D(
			Math.min(this.x1, other.x1),
			Math.min(this.y1, other.y1),
			Math.max(this.x2, other.x2),
			Math.max(this.y2, other.y2)
		);
	}
	
	public boolean equals(IndexRectangle2D other) {
		return 
			this.x1 == other.x1 &&
			this.x2 == other.x2 &&
			this.y1 == other.y1 &&
			this.y2 == other.y2;
	}
}
