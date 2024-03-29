package com.javabrains.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class AfterLoggingAspect {
	
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
	
//	@Before("allCircleMethods()")
//	public void loggingAdvice(JoinPoint joinPoint) { // this is advice
//		System.out.println(joinPoint.getTarget());
//	}
	

//	@After("args(name)")
//	public void stringArgumentsMethods(String name) { // this is advice
//		System.out.println("A method that takes String as argument has been called. The value is : "+name);
//	}


//	executes only after successful execution of method
//	@AfterReturning("args(name)")
//	public void stringArgumentsMethods(String name) { // this is advice
//		System.out.println("A method that takes String as argument has been called. The value is : "+name);
//	}

//	@AfterReturning(pointcut = "args(name)", returning = "returnString")
//	public void setNameandReturnmethodcall(String name, String returnString) { // this is advice
//		System.out.println("A method that takes String as argument has been called. The value is : "+name+""
//				+ " and Return value is :"+returnString);
//	}
//
//	
	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void afterThrowingadviceexpetion(String name, RuntimeException ex) { // this is advice
		System.out.println("An excpetion has thrown ....: "+ex);
	}
	
	
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}


	@Pointcut("within(com.javabrains.aop.model.Circle)")
	public void allCircleMethods() {}
	
	

	
}
