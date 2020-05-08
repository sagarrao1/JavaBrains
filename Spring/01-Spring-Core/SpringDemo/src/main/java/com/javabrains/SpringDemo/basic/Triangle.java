package com.javabrains.SpringDemo.basic;

import com.javabrains.SpringDemo.interfaceInject.Shape;

public class Triangle implements Shape  /* implements InitializingBean,DisposableBean */ {
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	//ApplicationContext context=null;
	
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
		System.out.println("draw method of triangle");
		System.out.println( "PointA = "+getPointA()+", PointB = "+pointB +" PointC = "+getPointC());
	}
}
