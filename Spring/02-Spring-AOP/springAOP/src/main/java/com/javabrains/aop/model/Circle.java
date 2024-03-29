package com.javabrains.aop.model;

import com.javabrains.aop.aspect.Loggable;

public class Circle {

	private String name;

	@Loggable
	public String getName() {
		System.out.println("Circle getName() method is called");
		return name;
	}

	public void setName(String name) {
//		System.out.println("Circle's setters is called");
		this.name = name;
		throw(new RuntimeException());
	}
	
//	@Loggable
	public String setNameAndReturn(String name) {
//		System.out.println("Circle's setters is called");
		this.name = name;
		return name;
		
	}

}
