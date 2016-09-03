package test;

import util.Point;
import util.Triangle;

/**
 * 生成一个三角形，以及三角形内一点
 * 
 * @author liuyuchen
 *
 */
public class GenerateTriangle {

	public static Triangle getTri() {
		// 产生第一个点
		Point a = getPoint();

		// 产生第二个点
		Point b;
		while (true) {
			b = getPoint();
			if (b.pEquel(a)) {
				continue;
			} else {
				break;
			}
		}

		// 产生第三个点
		Point c;
		while (true) {
			c = getPoint();
			if (inLine(a, b, c)) {
				continue;
			} else {
				break;
			}
		}

		return new Triangle(a, b, c);

	}

	// 随机产生一个点
	static Point getPoint() {
		// 产生的点在[0, 1000)*[0, 1000)的区域
		double x = getDouble();
		double y = getDouble();
		return new Point(x, y);
	}

	// 产生一个保留两位小数的double类型数
	private static double getDouble() {
		return (int) (Math.random() * 1000 * 100) / 100.0;
	}

	/**
	 * 判断一点是否在确定的直线上
	 * 
	 * @param a
	 * @param b
	 *            两点确定的直线
	 * @param tmp
	 *            待判断的点
	 * @return 如果点在直线上返回true，否则返回false
	 */
	public static boolean inLine(Point a, Point b, Point tmp) {
		if ((b.getY() - a.getY()) * (b.getX() - tmp.getX()) 
				- (b.getY() - tmp.getY()) * (b.getX() - a.getX()) < Math.exp(-6)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Triangle tri = GenerateTriangle.getTri();
		System.out.println(tri);
	}
}
