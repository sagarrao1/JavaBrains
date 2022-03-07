package com.javabrains.SpringDemo.basic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RectangleDemo {

	public static void main(String[] args) {
		
		try (ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml")) {
		Rectangle rectangle = appContext.getBean("rectangle", Rectangle.class);
		rectangle.draw();
		}
	}

}
