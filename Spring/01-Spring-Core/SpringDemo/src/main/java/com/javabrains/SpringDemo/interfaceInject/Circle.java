package com.javabrains.SpringDemo.interfaceInject;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;

import com.javabrains.SpringDemo.basic.Point;

//@Service
//@Component
public class Circle implements Shape/* ,BeanNameAware */ {

	private Point center;

	public void draw() {
		System.out.println("circle draw method");
		System.out.println("circle Point is (" + center.getX() + " , " + center.getY() + " )");
	}

	public Point getCenter() {
		return center;
	}

//	@Required
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "Circle [center=" + center + "]";
	}

	/*
	 * @Override public void setBeanName(String beanName) {
	 * System.out.println("Bean name is: "+beanName); }
	 */

	@PostConstruct
	public void initializeCircle() {
		System.out.println("Initialize my circle");
	}

	@PreDestroy
	public void destroyCircle() {
		System.out.println("destroy my circle");
	}

}
