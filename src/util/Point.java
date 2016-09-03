package util;

public class Point {
	private double x;
	private double y;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean pEquel(Point p) {
		if(x == p.getX() && y == p.getY()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "("+this.getX()+", "+this.getY()+")";
	}
}
