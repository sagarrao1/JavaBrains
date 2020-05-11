package com.javabrains.SpringJdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringJdbc.dao.JdbcDaoImpl;
import com.javabrains.SpringJdbc.dao.JdbcTemplateDaoImpl;
import com.javabrains.SpringJdbc.model.Circle;

public class JdbcDemo {
	public static void main(String[] args) {		
		ApplicationContext ctx=  new ClassPathXmlApplicationContext("spring.xml");		
		JdbcDaoImpl dao =ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
//		Circle circle=dao.getCircle(1);		
//		System.out.println(circle.getName());
		System.out.println(dao.getCircleCount());
		System.out.println(dao.getCircleName(1));
		Circle circle=  dao.getCircleforId(2);
		System.out.println(circle);
		System.out.println("size:" + dao.getAllCircles().size());
		
		List<Circle> list = dao.getAllCircles();
		
		for (Circle circle2 : list) {
			System.out.println(circle2);
			
		}
		
		dao.insertCircle(new Circle(6, "sIX circle"));
//		dao.createTrianlgeTable();
		
		
		/* Another way of creating jdbcdaoImpl using spring JdbcDaoSupport */
		JdbcTemplateDaoImpl dao2= ctx.getBean("jdbcTemplateDaoImpl", JdbcTemplateDaoImpl.class);
		System.out.println();
		System.out.println("Another way of creating jdbcdaoImpl using spring JdbcDaoSupport ");
		System.out.println("dao2 no.of records of circle : "+dao2.getCircleCount());
			
	}
}
