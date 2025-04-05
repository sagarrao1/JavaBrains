package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.basic.Triangle;


public class TriangleDemo 
{
    public static void main( String[] args )
    {
        //Triangle t= new Triangle();
    	try(ClassPathXmlApplicationContext context = 
    			new ClassPathXmlApplicationContext("spring.xml")){
    		Triangle t =(Triangle) context.getBean("triangle");    	
    		t.draw();    		
    	}

    }
}
