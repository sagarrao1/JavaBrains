package com.javabrains.SpringDemo.BeanLifeCycle;

import com.javabrains.SpringDemo.basic.Point;

public class TriangleNew /* implements InitializingBean, DisposableBean */  {

	private Point pointA;
	private Point pointB;
	private Point pointC;

	// ApplicationContext context=null;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		System.out.println("draw method of triangle New ");
		System.out.println("PointA = " + getPointA() + ", PointB = " + pointB + " PointC = " + getPointC());
	}

	/*
	 * @Override public void destroy() throws Exception {
	 * System.out.println("triangle_New DisposableBean destroy() method is called");
	 * }
	 * 
	 * @Override public void afterPropertiesSet() throws Exception { System.out.
	 * println("triangle_New InitializingBean int method is called using afterPropertiesSet() method "
	 * ); }
	 * 
	 * public void myInit() {
	 * System.out.println("triangle_New myInit() method is called"); }
	 * 
	 * public void myCleanup() {
	 * System.out.println("triangle_New myCleanup() method is called"); }
	 */
}
