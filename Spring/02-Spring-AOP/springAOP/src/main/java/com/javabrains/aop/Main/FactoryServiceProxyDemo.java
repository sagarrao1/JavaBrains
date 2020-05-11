package com.javabrains.aop.Main;

import com.javabrains.aop.service.FactoryService;
import com.javabrains.aop.service.ShapeService;

// this is demonistrate how aspect works
// it creates factory service Proxy object and use the proxy to weave through actual object
// to get control

public class FactoryServiceProxyDemo {

	public static void main(String[] args) {
		
//		try(ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml")){
//			ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
//			shapeService.getCircle();
			
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");

		shapeService.getCircle();
		
		
	}	
}
