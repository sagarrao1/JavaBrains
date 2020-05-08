package com.javabrains.SpringDemo.interfaceInject;

import org.springframework.beans.factory.annotation.Required;

import com.javabrains.SpringDemo.basic.Point;

//@Service
//@Component
public class Circle implements Shape {
	
	private Point center;
//	@Autowired

	public void draw() {
		System.out.println("circle draw method");
		System.out.println("circle Point is ("+center.getX()+" , "+center.getY()+" )");
	}

	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		this.center = center;
	}
	
	/*
	 * @PostConstruct public void initializeCircle() {
	 * System.out.println("Initialize my circle"); }
	 * 
	 * @PreDestroy public void destroyCircle() {
	 * System.out.println("destroy my circle"); }
	 * 
	 */}
