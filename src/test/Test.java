package test;

import getpoint.GetPoint;
import getpoint.GetPointImpl;
import getpoint.GetPointImpl2;
import util.Point;
import util.Triangle;

/**
 * 自动测试
 * 
 * @author liuyuchen
 *
 */
public class Test {
	
	private GetPoint gp;
	
	public Test(Class<? extends GetPoint> clazz) 
			throws InstantiationException, IllegalAccessException {
		gp = clazz.newInstance();
	}

	public boolean testOne() {
		// 随机产生一个三角形
		Triangle tri = GenerateTriangle.getTri();

		// 产生三角形内一点
		Point p;
		while (true) {
			p = GenerateTriangle.getPoint();
			if (tri.checkInTriangle(p)) {
				break;
			} else {
				continue;
			}
		}

		// 计算得到的tp点
		double pA = tri.length(tri.getA(), p);
		double pB = tri.length(tri.getB(), p);
		double pC = tri.length(tri.getC(), p);
		
		Point tp = gp.getPoint(tri, pA, pB, pC);
		
		if (Math.abs(tp.getX() - p.getX()) < 0.1 && Math.abs(tp.getY() - p.getY()) < 0.1) {
//			System.out.println("right.");
			return true;
		} else {
			System.err.println("The test data is wrong.");
			System.err.println("tri:" + tri);
			System.err.println("The real p is: "+ p);
			System.err.println("The p by calculation: " + tp);
			return false;
		}
	}
	
	/**
	 * 多次测试
	 * 
	 * @param testTimes
	 * 				一次测试的次数
	 */
	public void tests(int testTimes) {
		//计数器，记录错误结果数
		int wrongNum = 0;
		
		for(int i=1; i<=testTimes; i++) {
			if(!this.testOne()) {
				wrongNum ++;
			}
		}
		System.out.println("The sum of wrong result is " + wrongNum);
		System.out.println("The rate of wrong result is " + wrongNum/(double)testTimes);
	}
	
	public void tests() {
		int testTimes = 10000;
		this.tests(testTimes);
	}

	public static void main(String[] args) 
			throws InstantiationException, IllegalAccessException {
		Class clazz = GetPointImpl2.class;
		new Test(clazz).tests();
	}

}
