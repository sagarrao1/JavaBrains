package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.interfaceInject.Shape;

//Interface Dependency Injection using XML config
public class InterfaceDependecnyInjectXmlDemo 
{
    public static void main( String[] args )
    {

    	try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring3.xml")){
    		Shape shape =(Shape) context.getBean("circle");
//    		Shape shape =(Shape) context.getBean("triangle");    	
    		shape.draw();    		
    	}

    }
}
