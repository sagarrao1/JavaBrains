package com.javabrains.SpringDemo.basic;

import java.util.List;

import com.javabrains.SpringDemo.interfaceInject.Shape;

public class ListTriangle implements Shape /* implements InitializingBean,DisposableBean */ {

	private List<Point> points;	

	public List<Point> getPoints() {
		return points;
	}
	
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void draw() {
		System.out.println("draw method of ListTriangle");

		for (Point point : points) {
			System.out.println(point);
		}

	}

	/*
	 * public void afterPropertiesSet() throws Exception {
	 * System.out.println(" Initialized bean method has been called in Triangle");
	 * 
	 * }
	 * 
	 * public void destroy() throws Exception {
	 * System.out.println(" destroy bean method has been called in Triangle");
	 * 
	 * }
	 * 
	 * public void myInit() { System.out.
	 * println(" myInit Initialized bean method has been called in Triangle"); }
	 * 
	 * public void myCleanup() { System.out.
	 * println(" myCleanup Initialized bean method has been called in Triangle"); }
	 * 
	 * 
	 * public void setApplicationContext(ApplicationContext context) throws
	 * BeansException { this.context=context;
	 * 
	 * } public void setBeanName(String name) {
	 * System.out.println("Bean Name : "+name);
	 * 
	 * }
	 * 
	 */
}
