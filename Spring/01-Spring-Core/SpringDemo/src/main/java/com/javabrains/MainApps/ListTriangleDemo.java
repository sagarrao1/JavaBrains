package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.basic.ListTriangle;


// setting list values of Bean in spring.xml
public class ListTriangleDemo 
{
    public static void main( String[] args )
    {
     	
    	try(  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")){
    		ListTriangle t =(ListTriangle) context.getBean("listTriangle");    	
    		t.draw();    		
    	}
    }
}
