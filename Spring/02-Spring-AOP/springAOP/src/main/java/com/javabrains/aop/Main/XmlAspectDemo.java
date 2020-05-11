package com.javabrains.aop.Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.aop.service.ShapeService;

public class XmlAspectDemo {

	public static void main(String[] args) {
		
		try(ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("springXmlConfig.xml")){
			ShapeService shapeService = context.getBean("shapeService", ShapeService.class);						
			shapeService.getCircle().getName();
			

		}

	}
}
