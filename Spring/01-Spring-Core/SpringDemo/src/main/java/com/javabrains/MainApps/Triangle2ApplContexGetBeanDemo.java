package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.ApplContextgetBean.Triangle2;


public class Triangle2ApplContexGetBeanDemo 
{
    public static void main( String[] args )
    {
    	
    	try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")){
    		Triangle2 t =(Triangle2) context.getBean("triangle2");    	
    		t.draw();    		
    	}
    }
}
