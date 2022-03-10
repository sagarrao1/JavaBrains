package com.javabrains.EventHandling;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.javabrains.SpringDemo.basic.Point;
import com.javabrains.SpringDemo.interfaceInject.Shape;

public class Circle implements Shape , ApplicationEventPublisherAware  {

	private Point center;

	private ApplicationEventPublisher publisher;

	public void draw() {
		System.out.println("EventHandling circle draw method");
		System.out.println("EventHandling circle Point is (" + center.getX() + " , " + center.getY() + " )");

//to publish event we need to create DrawEvent Object which will have source of this Circle class and publish this event
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	// to publish events we need to get hold of ApplicationEventPublisher
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

}
