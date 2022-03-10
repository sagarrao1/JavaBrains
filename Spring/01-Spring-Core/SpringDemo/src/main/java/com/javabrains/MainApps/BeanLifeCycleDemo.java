package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.BeanLifeCycle.TriangleNew;

//Reading values from property file using PropertyPlaceholderConfigurer

public class BeanLifeCycleDemo 
{

	public static void main( String[] args )
    {
    	
        //Triangle t= new Triangle();
    	try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring3.xml")){
//    		context.registerShutdownHook();
    		TriangleNew t =(TriangleNew) context.getBean("triangleNew");    	
    		t.draw();    		
    	}

    }
}
