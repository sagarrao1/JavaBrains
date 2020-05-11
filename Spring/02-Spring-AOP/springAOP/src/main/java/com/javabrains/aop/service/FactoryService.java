package com.javabrains.aop.service;

import com.javabrains.aop.model.Circle;
import com.javabrains.aop.model.Triangle;

public class FactoryService {
	
	public Object getBean(String beanType) {
		
		if(beanType.equals("shapeService")) return new ShapeServiceProxy();
		if(beanType.equals("circle")) return new Circle();
		if(beanType.equals("triangle")) return new Triangle();
		
		return null;
	}
}
