package lib.geom;

public class Index2D {
	public final int x;
	public final int y;
	
	public Index2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object other) {
		if(!(other instanceof Index2D)) {
			return false;
		}
		Index2D otherIndex = (Index2D) other;
		return otherIndex.x == x && otherIndex.y == y;
	}
	
	public String toString() {
		return "Index [" + x + ", " + y + "]";
	}
}
