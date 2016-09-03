package util;

public class Triangle {
	// 三角形三个顶点
	private Point a;
	private Point b;
	private Point c;

	public Point getA() {
		return a;
	}
	public Point getB() {
		return b;
	}
	public Point getC() {
		return c;
	}

	// 三角形三条边，la表示点a对应的边
	private double la = 0;
	private double lb = 0;
	private double lc = 0;

	public double getLa() {
		return la;
	}
	public double getLb() {
		return lb;
	}
	public double getLc() {
		return lc;
	}
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
		la = this.length(this.b, this.c);
		lb = this.length(this.a, this.c);
		lc = this.length(this.a, this.b);
	}

	// 求三角形周长
	double perimeter() {
		return la + lb + lc;
	}

	// 求三角形面积
	public double square() {
		double p = this.perimeter() / 2;
		return Math.sqrt(p * (p - la) * (p - lb) * (p - lc));
	}

	// 求三角形面积
	public double square(double ab, double bc, double ca) {
		double p = (ab + bc + ca) / 2;
		return Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
	}

	// 求两点的间距离，这里用来求三角形边长
	public double length(Point x1, Point x2) {
		return Math.sqrt(
				(x2.getX() - x1.getX()) * (x2.getX() - x1.getX()) 
			  + (x2.getY() - x1.getY()) * (x2.getY() - x1.getY()));
	}
	
	// 判断给定点是否在该三角形内
	public boolean checkInTriangle(Point p) {
		double tPA = this.length(p, this.getA());
		double tPB = this.length(p, this.getB());
		double tPC = this.length(p, this.getC());

		double sPAB = this.square(tPA, tPB, this.getLc());
		double sPBC = this.square(tPB, tPC, this.getLa());
		double sPCA = this.square(tPC, tPA, this.getLb());

		if (Math.abs((sPAB + sPBC + sPCA - this.square())) < 0.1) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return a+"\n"+b+"\n"+c;
	}
}
