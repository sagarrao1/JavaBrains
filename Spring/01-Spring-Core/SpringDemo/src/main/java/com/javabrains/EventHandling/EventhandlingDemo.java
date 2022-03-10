package com.javabrains.EventHandling;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.interfaceInject.Shape;

//Application context additional features
public class EventhandlingDemo {

	public static void main(String[] args) {
		
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring5.xml")){
			Shape circle= (Shape) context.getBean("circleE");
			circle.draw();			
			
		}
		

	}

}
