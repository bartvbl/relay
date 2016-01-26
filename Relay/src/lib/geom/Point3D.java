package lib.geom;

public class Point3D {
	public final double x;
	public final double y;
	public final double z;

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String toString() {
		return "[" + x + ", " + y + ", " + z + "]";
	}

	public double distanceTo(Point3D other) {
		double dx = other.x - x;
		double dy = other.y - y;
		double dz = other.z - z;

		return Math.sqrt(dx*dx + dy*dy + dz*dz);
	}
}
