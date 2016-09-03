package getpoint;

import util.Point;
import util.Triangle;

/**
 * 检验结果
 * 
 * 方法：
 * 判断求得的点是否在三角形内
 * 判断该点到三顶点的距离与给定的距离差距是否在给定精度内
 * 
 * @author liuyuchen
 *
 */
public class Check {
	// 三角形
	Triangle tri;

	// 求得的点p
	private Point p;

	// 给定的p点到三个顶点的距离
	private double pA;
	private double pB;
	private double pC;

	public Check(Point a, Point b, Point c, 
			Point p, 
			double pA, double pB, double pC) {
		tri = new Triangle(a, b, c);
		this.p = p;
		this.pA = pA;
		this.pB = pB;
		this.pC = pC;
	}

	public boolean check() {
		if (this.checkDistance()) {
			if (this.checkInTriangle()) {
				System.out.println("The p is correct.");
				return true;
			} else {
				System.out.println("The p is out of the triangle.");
				return false;
			}
		} else {
			System.out.println("The p is wrong.");
			return false;
		}
	}

	/**
	 * 验证求出的点是不是满足到三点的距离
	 */
	private boolean checkDistance() {
		//精度
		double acc = 0.5;
		
		if ((tri.length(p, tri.getA()) - pA) < acc 
				&& (tri.length(p, tri.getB()) - pB) < acc
				&& (tri.length(p, tri.getC()) - pC) < acc) {

			return true;

		} else {
			return false;
		}
	}

	/**
	 * 检查p点是不是在三角形内部 
	 * 方法：如果p点再三角形内部（或三角形上），则三角形APB、BPC、CPA的面积和等于三角形ABC的面积， 
	 * 否则为大于
	 */
	private boolean checkInTriangle() {
		double tPA = tri.length(p, tri.getA());
		double tPB = tri.length(p, tri.getB());
		double tPC = tri.length(p, tri.getC());

		double sPAB = tri.square(tPA, tPB, tri.getLc());
		double sPBC = tri.square(tPB, tPC, tri.getLa());
		double sPCA = tri.square(tPC, tPA, tri.getLb());

		//
		double acc = Math.exp(-6);
		if (Math.abs((sPAB + sPBC + sPCA - tri.square())) < acc) {
			return true;
		} else {
			return false;
		}
	}

}
