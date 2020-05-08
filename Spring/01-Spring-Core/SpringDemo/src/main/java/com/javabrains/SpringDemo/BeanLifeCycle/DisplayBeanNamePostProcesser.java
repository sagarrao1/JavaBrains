package com.javabrains.SpringDemo.BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayBeanNamePostProcesser implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(" Before bean initialization of bean "+beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(" After bean initialization of bean "+beanName);
		return bean;
	}

}
