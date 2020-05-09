package com.javabrains.aop.Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.aop.service.ShapeService;

public class AopAroundAspectDemo {

	public static void main(String[] args) {
		
		try(ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml")){
			ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
			shapeService.getCircle();
			
		}

	}
}
