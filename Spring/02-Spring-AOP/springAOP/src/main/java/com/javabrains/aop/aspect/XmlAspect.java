package com.javabrains.aop.aspect;

// Using Xml config insteabd annotations
// this is to understand and legacy code, for new code we will use annotations

//@Aspect
public class XmlAspect {
		
//	@After("allGetters()")
	public void afterAdvice() { // this is advice
		System.out.println(" after advice called using XML configuration aspect advice !!! ");
	}
	
	
//	@Pointcut("execution(* get*(..))")
	public void allGetters() {}
	
}
