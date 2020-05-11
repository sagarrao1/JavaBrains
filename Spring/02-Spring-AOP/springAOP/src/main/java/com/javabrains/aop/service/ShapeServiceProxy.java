package com.javabrains.aop.service;

import com.javabrains.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	//overriding getCircle of super class. i.e ShapeService
	public Circle getCircle() {		
		
		new FactoryLoggingAspect().loggingAdvice();  // mimic of before advice without using aspect 
		return super.getCircle(); // this is actual method of ShapeService
		// you can write after
	}

}
