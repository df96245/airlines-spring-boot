package com.deyi.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionAspect {
	
	private static Logger logger =LoggerFactory.getLogger(LogAspect.class);
	
	@Pointcut("execution(* com.deyi.springboot.repository..*(..)) ")  
	public void transactionMethodPointcut(){}  
	
	@Around("transactionMethodPointcut()")
	public Object aroudController(ProceedingJoinPoint pjp) throws Throwable{
		StringBuilder className=new StringBuilder(pjp.getTarget().getClass().getName());
		className.append("("+pjp.getSignature().getName()+")" );
		logger.info("#####begin processing database operation #####"+className);
		Object rVal=pjp.proceed();
		logger.info("#####end   processed  database operation #####"+className+" result:"+rVal.toString());
		return rVal;
	}
}
