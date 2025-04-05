package com.javabrains.MessageSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.interfaceInject.Shape;

//Application context additional features
public class MessagingAppCtxFeaturesDemo {

	public static void main(String[] args) {
		
		try(ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("spring5.xml")){
			Circle circle= (Circle) context.getBean("circle");
			circle.draw();			
			
			System.out.println();
//			System.out.println(context.getMessage("greeting", null, "Default greeting !!!", null));
//			System.out.println(context.getMessage("circle.point", new Object[] {circle.getCenter().getX(),circle.getCenter().getY()}, "Default greeting !!!", null));
		}
		

	}

}
