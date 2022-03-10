package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.ApplContextgetBean.Triangle2;
import com.javabrains.SpringDemo.basic.Point;


public class Triangle2ApplContexGetBeanDemo 
{
    public static void main( String[] args )
    {
    	
    	try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")){
    		Triangle2 t =(Triangle2) context.getBean("triangle2");    	
    		t.draw();
    		
    		
//    		 bean inheritence using	Parent bean 
//    		
//    		Triangle2 t4 =(Triangle2) context.getBean("triangle4");    	
//    		t4.draw();
    		
//    		System.out.println("Triangle2 : "+t);
//    		
//    		Triangle2 b =(Triangle2) context.getBean("triangle2");
//    		System.out.println("Triangle2 : "+b);
    		
//    		Point a = context.getBean("pointA", Point.class);
//    		System.out.println("pointA : "+a);
//    		
//    		Point b = context.getBean("pointA", Point.class);
//    		System.out.println("pointA : "+b);
//    		
//    		Point b1 = context.getBean("pointB", Point.class);
//    		System.out.println("pointA : "+b1);
    		
//    		System.out.println("pointB : "+pointB);
//    		System.out.println("pointC : "+pointC);
    	}
    }
}
