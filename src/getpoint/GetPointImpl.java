package getpoint;
import java.util.Formatter;

import util.Point;
import util.Triangle;

/**
 * 给定一个三角形，以及三角形内一点P到三个顶点的距离，求该点坐标
 * 
 * 思路：
 * 列三个圆方程，求解
 * 通过两个圆方程相减获得直线方程
 * 不同的方程相减可以得到两个直线方程
 * 
 * @author liuyuchen
 *
 */
public class GetPointImpl implements GetPoint{
	
	//存储P点坐标
	private double x;
	private double y;
	
	//点A
	private double x1;
	private double y1;
	//点B
	private double x2;
	private double y2;
	//点C
	private double x3;
	private double y3;
	//点到三角形顶点的距离
	private double pA;
	private double pB;
	private double pC;
	
	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public double getX3() {
		return x3;
	}

	public void setX3(double x3) {
		this.x3 = x3;
	}

	public double getY3() {
		return y3;
	}

	public void setY3(double y3) {
		this.y3 = y3;
	}

	public double getpA() {
		return pA;
	}

	public void setpA(double pA) {
		this.pA = pA;
	}

	public double getpB() {
		return pB;
	}

	public void setpB(double pB) {
		this.pB = pB;
	}

	public double getpC() {
		return pC;
	}

	public void setpC(double pC) {
		this.pC = pC;
	}

	public GetPointImpl() {}
	
	public GetPointImpl(double x1, double y1, 
			double x2, double y2, 
			double x3, double y3, 
			double pA, double pB, double pC) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.pA = pA;
		this.pB = pB;
		this.pC = pC;
	}
	
	public Point getPoint() {
		return this.getPoint(x1, y1, x2, y2, x3, y3, pA, pB, pC);
	}
	
	//求点
	public Point getPoint(Point a, Point b, Point c, double pA, double pB, double pC) {
		
		if(pA == 0) {	//p在A点
			x = a.getX();
			y = a.getY();
			return a;
		}
		if(pB == 0) {	//p在B点
			x = b.getX();
			y = b.getY();
			return b;
		}
		if(pC == 0) {	//p在C点
			x = c.getX();
			y = c.getY();
			return c;
		}
		
		if ((b.getX() - a.getX()) == 0) {
			y = (pA * pA - pB * pB + b.getY() * b.getY() - a.getY() * a.getY()) 
					/ (2 * (b.getY() - a.getY()));
			x = (pA*pA - pC*pC + c.getX()*c.getX() - a.getX()*a.getX() 
					- (c.getY() - a.getY())*(2*y - a.getY() - c.getY()))
					/ (2 * (c.getX() - a.getX()));
		} else if ((c.getX() - a.getX()) == 0) {
			y = (pA * pA - pC * pC + c.getY() * c.getY() - a.getY() * a.getY()) 
					/ (2 * (c.getY() - a.getY()));
			x = (pA*pA - pB*pB + b.getX()*b.getX() - a.getX()*a.getX() 
					- (b.getY() - a.getY())*(2*y - a.getY() - b.getY()))
					/ (2 * (b.getX() - a.getX()));
		} else if ((b.getY() - a.getY()) == 0) {
			x = (pA * pA - pB * pB + b.getX() * b.getX() - a.getX() * a.getX()) 
					/ (2 * (b.getX() - a.getX()));
			y = (pA*pA - pC*pC + c.getY()*c.getY() - a.getY()*a.getY() 
					- (c.getX() - a.getX())*(2*x - a.getX() - c.getX()))
					/ (2 * (c.getY() - a.getY()));
		} else if ((c.getY() - a.getY()) == 0) {
			x = (pA * pA - pC * pC + c.getX() * c.getX() - a.getX() * a.getX()) 
					/ (2 * (c.getX() - a.getX()));
			y = (pA*pA - pB*pB + b.getY()*b.getY() - a.getY()*a.getY() 
					- (b.getX() - a.getX())*(2*x - a.getX() - b.getX()))
					/ (2 * (b.getY() - a.getY()));
		} else {
			//四个中间量，方便式子表达
			double m1 = (pA*pA - pB*pB + b.getY()*b.getY() - a.getY()*a.getY()) 
					* (c.getY() - a.getY());
			double m2 = (pA*pA - pC*pC + c.getY()*c.getY() - a.getY()*a.getY()) 
					* (b.getY() - a.getY());
			double n1 = (c.getY() - a.getY()) * (b.getX() - a.getX());
			double n2 = (b.getY() - a.getY()) * (c.getX() - a.getX());
			
			x = (m1 - m2 + n1*(a.getX()+b.getX()) - n2*(a.getX()+c.getX())) 
					/ (2 * ( n1 - n2));
			y = (pA*pA - pB*pB + b.getY()*b.getY() - a.getY()*a.getY() 
					- (b.getX() - a.getX())*(2*x - a.getX() - b.getX()))
					/ (2 * (b.getY() - a.getY()));
		}

		@SuppressWarnings("resource")
		Formatter f = new Formatter(System.out);
        // 格式化输出
        f.format("(Xp, Yp)=(%.2f, %.2f)\n", x, y); 
        
        return new Point(x, y);
	}
	
	public Point getPoint(Triangle tri, double pA, double pB, double pC) {
		return this.getPoint(tri.getA(), tri.getB(), tri.getC(), pA, pB, pC);
	}

	public Point getPoint(double x1, double y1, 
			double x2, double y2, 
			double x3, double y3, 
			double pA, double pB, double pC) {
		Point a = new Point(x1, y1);
		Point b = new Point(x2, y2);
		Point c = new Point(x3, y3);
		
		return this.getPoint(a, b, c, pA, pB, pC);
	}

	public static void main(String[] args) {
		// 通过A、B、C三点给定三角形
		Point A = new Point(50, 100);
		Point B = new Point(0, 0);
		Point C = new Point(100, 0);
		// 给定某点P到三个顶点的距离
		double pA = 50;
		double pB = 70.7;
		double pC = 70.7;
		// 求点P
		Point p = new GetPointImpl().getPoint(A, B, C, pA, pB, pC);
		System.out.println(p);
		new Check(A, B, C, p, pA, pB, pC).check();
		
		// 通过A、B、C三点给定三角形
		Point A1 = new Point(180, 280);
		Point B1 = new Point(100, 100);
		Point C1 = new Point(200, 20);
		// 给定某点P到三个顶点的距离
		double pA1 = 160.3;
		double pB1 = 71.4;
		double pC1 = 104.4;
		// 求点P
		Point p1 = new GetPointImpl().getPoint(A1, B1, C1, pA1, pB1, pC1);
		new Check(A1, B1, C1, p1, pA1, pB1, pC1).check();
	}

}
