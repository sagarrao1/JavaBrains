package com.javabrains.SpringDemo.ApplContextgetBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.javabrains.SpringDemo.basic.Point;

//Using Application context getBean  in your bean (Trianngle)
//when we use this, when Triangle scope is singleton, pointA asre prototype
// you will be able to use getBean of pointA , if you want to do that you need to get application context get bean in you bean

public class Triangle2 implements ApplicationContextAware , BeanNameAware {
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	ApplicationContext context=null;
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
 
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}


	public void draw() {
		System.out.println("draw method of triangle");
		System.out.println( "PointA = "+getPointA()+", PointB = "+pointB +" PointC = "+getPointC());
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println(" Initialized bean method has been called in Triangle");
		
	}

	public void destroy() throws Exception {
		System.out.println(" destroy bean method has been called in Triangle");
		
	}
	
	public void myInit() {
		System.out.println(" myInit Initialized bean method has been called in Triangle");
	}
	
	public void myCleanup() {
		System.out.println(" myCleanup Initialized bean method has been called in Triangle");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context=applicationContext;
		
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean name is: "+beanName);
		
	}


}
