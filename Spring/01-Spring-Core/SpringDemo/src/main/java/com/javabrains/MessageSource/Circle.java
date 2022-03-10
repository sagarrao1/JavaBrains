package com.javabrains.MessageSource;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

import com.javabrains.SpringDemo.basic.Point;
import com.javabrains.SpringDemo.interfaceInject.Shape;


public class Circle implements Shape {
	
	private Point center;
	
	@Autowired
	private MessageSource messageSource;
	
	public void draw() {
//		System.out.println("circle draw method");
//		System.out.println("circle Point is ("+center.getX()+" , "+center.getY()+" )");
		
		
		System.out.println(messageSource.getMessage("circle.msg1", null, "Default greeting !!!", Locale.US));	
//		printing above "circle draw method" using messageSource 
		System.out.println(messageSource.getMessage("circle.draw", null, "Default greeting",Locale.UK));

		
//		System.out.println("circle Point is ("+center.getX()+" , "+center.getY()+" )");
		System.out.println(messageSource.getMessage("circle.point", new Object[] {center.getX(),center.getY()}, "Default point message", Locale.GERMANY));
		System.out.println(messageSource.getMessage("circle.point", new Object[] {center.getX(),center.getY()}, "Default point message", Locale.GERMANY));

	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}


}
