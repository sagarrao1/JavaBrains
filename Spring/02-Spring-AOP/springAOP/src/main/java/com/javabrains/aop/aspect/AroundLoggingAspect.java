package com.javabrains.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class AroundLoggingAspect {

	@Around("allGetters()")
	public Object myaroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		Object returnValue=null;
		
		System.out.println("Before advice");
		
		returnValue=proceedingJoinPoint.proceed();
		
		System.out.println("After advice");
		
		return returnValue;
	}
	
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}


	@Pointcut("within(com.javabrains.aop.model.Circle)")
	public void allCircleMethods() {}
	
	// point cut to fetch service package which ends with service in class
	@Pointcut("within(com.javabrains.service.*service)")
	public void allserviceclasses() {}
	

	
}
