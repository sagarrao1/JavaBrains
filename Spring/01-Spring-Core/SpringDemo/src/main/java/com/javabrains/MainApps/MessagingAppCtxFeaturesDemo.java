package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.interfaceInject.Shape;

//Application context additional features
public class MessagingAppCtxFeaturesDemo {

	public static void main(String[] args) {
		
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring5.xml")){
			Shape circle= (Shape) context.getBean("circle");
			circle.draw();			
			
//			Circle circle= (Circle) context.getBean("circle");
//			circle.draw();
			
			
//			System.out.println(context.getMessage("greeting", null, "Default greeting !!!", null));
//			System.out.println(context.getMessage("circle.draw2", new Object[] {circle.getCenter().getX(),circle.getCenter().getY()}, "Default greeting !!!", null));
		}
		

	}

}
