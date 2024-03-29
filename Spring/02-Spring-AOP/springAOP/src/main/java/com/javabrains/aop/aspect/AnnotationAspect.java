package com.javabrains.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class AnnotationAspect {
		
	@After("@annotation(com.javabrains.aop.aspect.Loggable)")
	public void afterAdvice() { // this is advice
		System.out.println(" after advice called using annotaion Loggable ....");
	}
	
	
//	@Pointcut("execution(* get*(..))")
//	public void allGetters() {}
	
}
