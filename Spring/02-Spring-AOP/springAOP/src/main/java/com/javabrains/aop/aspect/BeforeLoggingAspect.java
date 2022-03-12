package com.javabrains.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.javabrains.aop.model.Circle;

//@Aspect
public class BeforeLoggingAspect {
	
//	@Before("execution(public String getName())")  // Point cut
//	@Before("execution(public String com.javabrains.aop.model.Circle.getName())")
////	@Before("execution(* get*(..))")	
//	@Before("allCircleMethods() || allGetters()")
//	public void loggingAdvice() { // this is advice
//		System.out.println("Aspect Advice run. get method is called");
//	}

//	@Before("allGetters()")
//	public void secondAdvice() {
//		System.out.println("second Advice run. get method is called");
//	}
	
//	@Before("allGetters()")
//	public void thirdAdvice() {
//		System.out.println("third Advice run. get method is called");
//	}	

	//using joint point
	
//	@Before("allCircleMethods()")
//	public void loggingAdvice(JoinPoint joinPoint) { // this is advice
////		Circle circle = (Circle) joinPoint.getTarget(); // we get hold of object to do something
////		System.out.println(joinPoint.toString());
//		System.out.println(joinPoint.getTarget().getClass().getSimpleName()+" Aspect Advice run using JoinPoint");
//	}
	

	@Before("args(name)")
	public void stringArgumentsMethods(String name) { // this is advice
		System.out.println("A method that takes String as argument has been called. The value is : "+name);
	}
//
//	
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}


	@Pointcut("within(com.javabrains.aop.model.Circle)")
	public void allCircleMethods() {}
	
		
}
