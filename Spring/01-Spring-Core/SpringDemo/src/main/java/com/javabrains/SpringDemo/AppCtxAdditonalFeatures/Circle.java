package com.javabrains.SpringDemo.AppCtxAdditonalFeatures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

import com.javabrains.SpringDemo.basic.Point;
import com.javabrains.SpringDemo.interfaceInject.Shape;

//@Service
//@Component
public class Circle implements Shape, ApplicationEventPublisherAware {
	
	private Point center;
	
	@Autowired
	private MessageSource messageSource;
	
	private ApplicationEventPublisher publisher;
	
	
	public void draw() {
		System.out.println("circle draw method");
		System.out.println("circle Point is ("+center.getX()+" , "+center.getY()+" )");
		
		
//		System.out.println(messageSource.getMessage("circle.draw", null, "Default greeting !!!", null));
//		System.out.println(messageSource.getMessage("circle.draw2", new Object[] {center.getX(),center.getY()}, "Default greeting !!!", null));
		
		//to publish event we need to create DrawEvent Object which will have source of this Circle class and publish this event
		DrawEvent drawEvent = new DrawEvent(this);		
		publisher.publishEvent(drawEvent);
	}

	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		this.center = center;
	}

	// to publish events we need to get hold of ApplicationEventPublisher
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;		
	}


}
