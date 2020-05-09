package com.javabrains.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class BeforeLoggingAspect {
	
//	@Before("execution(public String getName())")  // Point cut	
//	@Before("execution(* get*(..))")
	
//	@Before("allCircleMethods()")
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
	
	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint) { // this is advice
//		System.out.println(joinPoint.getTarget());
	}
	

	@Before("args(name)")
	public void stringArgumentsMethods(String name) { // this is advice
		System.out.println("A method that takes String as argument has been called. The value is : "+name);
	}

	
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}


	@Pointcut("within(com.javabrains.aop.model.Circle)")
	public void allCircleMethods() {}
	
	

	
}
