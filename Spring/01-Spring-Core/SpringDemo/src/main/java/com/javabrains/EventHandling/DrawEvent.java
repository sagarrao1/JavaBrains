package com.javabrains.EventHandling;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent{

	public DrawEvent(Object source) {
		super(source);
	}

	@Override
	public String toString() {
		return "DrawEvent occured using ApplicationEvent publisher and and ApplicationEvent Listener";
	}

}
