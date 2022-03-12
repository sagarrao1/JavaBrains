package com.javabrains.aop.service;

import com.javabrains.aop.aspect.Loggable;
import com.javabrains.aop.model.Circle;
import com.javabrains.aop.model.Triangle;

public class ShapeService {
	
	private Circle circle;
	private Triangle triangle;
	
	@Loggable
	public Circle getCircle() {
		System.out.println("ShapeService getCircle() method is called");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	

}
