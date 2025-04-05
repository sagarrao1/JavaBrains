package com.javabrains.SpringJdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringJdbc.dao.PlainJdbcDaoImpl;
import com.javabrains.SpringJdbc.model.Circle;

public class PlainJdbcDemo {
	public static void main(String[] args) {	
		
		/* Using plan jdbc style without using application context */
//		Circle circle = new PlainJdbcDaoImpl().getCircle(1);
//		System.out.println(circle.getName());		
		
		  try(ClassPathXmlApplicationContext ctx= 
				  new ClassPathXmlApplicationContext("spring.xml")){			  
			  PlainJdbcDaoImpl dao =ctx.getBean("plainJdbcDaoImpl",PlainJdbcDaoImpl.class);
			  Circle circle=dao.getCircle(1); 
			  System.out.println(circle.getName());
		  }
	}
}
