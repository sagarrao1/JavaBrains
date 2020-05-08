package com.javabrains.MainApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javabrains.SpringDemo.basic.Triangle;

/*in Spring.xml, lets say
only zeroPoint is common beans which is used by other classes, so make it separate entry
rest point2, point3 is are only used in traingle , so we make use in trinagle instead of making them common beans
*/

public class TrianleInnerBeansCreationDemo 
{
    public static void main( String[] args )
    {
    	// Java 8 way try block
    	try( ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("InnerAndAlianBeans.xml")){
    	
    		Triangle t =(Triangle) context.getBean("triangle");    	
            t.draw();
            
    		Triangle t2 =(Triangle) context.getBean("triangle-alias");    // we can call using alias also. alias is mentioned in sprin2.xml	
            t2.draw();

    		Triangle t3 =(Triangle) context.getBean("triangle-name");    // we can call using alias also. alias is mentioned in sprin2.xml	
            t3.draw();

    	}
    	
    }
}
