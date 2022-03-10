package com.javabrains.SpringDemo.Annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.javabrains.SpringDemo.basic.Point;
import com.javabrains.SpringDemo.interfaceInject.Shape;

//@Service
//@Component
public class Circle2 implements Shape/* , ApplicationEventPublisherAware */ {

	private Point center;

	public void draw() {
		System.out.println("circle2 draw method");
		System.out.println("circle Point is (" + center.getX() + " , " + center.getY() + " )");
		// System.out.println(messageSource.getMessage("circle.draw", null,"default
		// message",null));
		// System.out.println(messageSource.getMessage("circle.draw2", new Object[]
		// {center.getX(),center.getY()},"default message",null));
//		DrawEvent drawEvent= new DrawEvent(this);		
//		publisher.publishEvent(drawEvent);
	}

	public Point getCenter() {
		return center;
	}

	@Resource(name = "pointA")   // JSR-250 standard  JSR = Java specification Request (Java standard)
//	@Resource
//	@Autowired
//	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

//	@PostConstruct
	public void initializeCircle() {
		System.out.println("Initialize my circle");
	}

//	@PreDestroy
	public void destroyCircle() {
		System.out.println("destroy my circle");
	}

//	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
//		this.publisher = publisher;
//	}

}
