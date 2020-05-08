package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.interfaceInject.Shape;

//Interface Dependency Injection using Annotation config
public class InterfaceDependecnyInjectAnnotationDemo 
{
    public static void main( String[] args )
    {

    	try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml")){
    		Shape shape =(Shape) context.getBean("circle2");    		    	
    		shape.draw();    		
    	}

    }
}
