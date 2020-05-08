package com.javabrains.SpringDemo.BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcesser implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("my Bean factory post process method is called");

	}

}
