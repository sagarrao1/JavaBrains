package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.basic.ListTriangle;
import com.javabrains.SpringDemo.basic.Triangle;


public class TriangleBean_InheritenceDemo 
{
    public static void main( String[] args )
    {
        //Triangle t= new Triangle();
    	try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanInheritence.xml")){
    		
    		Triangle trian =(Triangle) context.getBean("triangle");    	
    		trian.draw();

    		Triangle trian2 =(Triangle) context.getBean("triangle2");    	
    		trian2.draw();
    		
    		ListTriangle listTrain =(ListTriangle) context.getBean("listTriangle");    	
    		listTrain.draw();
    		
    		ListTriangle listTrain2 =(ListTriangle) context.getBean("listTriangle2");    	
    		listTrain2.draw();
    		
    	}

    }
}
