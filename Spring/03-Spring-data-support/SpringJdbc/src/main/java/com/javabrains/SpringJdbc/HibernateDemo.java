package com.javabrains.SpringJdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringJdbc.dao.HibernateDaoImpl;

public class HibernateDemo {
	public static void main(String[] args){		
		
		try(ClassPathXmlApplicationContext ctx= 
				new ClassPathXmlApplicationContext("spring.xml")){	
			HibernateDaoImpl dao =ctx.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
		System.out.println(dao.getCircleCount());
			
		}

		
		
	}
}
