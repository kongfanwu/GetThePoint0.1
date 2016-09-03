package getpoint;

import util.Point;
import util.Triangle;

public interface GetPoint {
	
	public Point getPoint();
	
	/**
	 * 通过给定三角形和内点p到三顶点距离求该内点p
	 * 
	 * @param tri
	 * 			三角形
	 * @param pA
	 * @param pB
	 * @param pC
	 * 			内点p到三角形三顶点距离
	 * @return
	 * 			p点坐标
	 */
	public Point getPoint(Triangle tri, double pA, double pB, double pC);
	
	/**
	 * 通过给定三角形三个顶点和内点p到三顶点距离求该内点p
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * 			三角形三个顶点
	 * @param pA
	 * @param pB
	 * @param pC
	 * 			内点p到三角形三顶点距离
	 * @return
	 * 			p点坐标
	 */
	public Point getPoint(Point a, Point b, Point c, double pA, double pB, double pC);
	
	/**
	 * 通过给定三角形三个顶点具体坐标和内点p到三顶点距离求该内点p
	 * 
	 * @param x1
	 * @param y1
	 * 			三角形A顶点
	 * @param x2
	 * @param y2
	 * 			三角形B顶点
	 * @param x3
	 * @param y3
	 * 			三角形C顶点
	 * @param pA
	 * @param pB
	 * @param pC
	 * 			内点p到三角形三顶点距离
	 * @return
	 * 			p点坐标
	 */
	public Point getPoint(double x1, double y1, 
			double x2, double y2, 
			double x3, double y3, 
			double pA, double pB, double pC);
	
}
