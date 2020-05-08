package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.basic.Triangle;


public class TriangleAutoWireXmlByNameDemo 
{
    public static void main( String[] args )
    {	
    	try(  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")){
    		Triangle t =(Triangle) context.getBean("triangleAutoWire");    	
    		t.draw();    		
    	}    	
    }
}
