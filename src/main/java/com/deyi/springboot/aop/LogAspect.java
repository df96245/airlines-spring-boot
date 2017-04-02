package com.deyi.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	private static Logger logger =LoggerFactory.getLogger(LogAspect.class);
	
	@Pointcut("execution(* com.deyi.springboot.controller..*(..)) "
			+ "and @annotation(org.springframework.web.bind.annotation.RequestMapping)")  
	public void controllerMethodPointcut(){}  
	
	@Around("controllerMethodPointcut()")
	public Object aroudController(ProceedingJoinPoint pjp) throws Throwable{
		StringBuilder className=new StringBuilder(pjp.getTarget().getClass().getName());
		className.append("("+pjp.getSignature().getName()+")" );
		logger.info("#####begin processing controller #####"+className);
		Object rVal=pjp.proceed();
		logger.info("#####end processed controller #####"+className+" result:"+rVal.toString());
		return rVal;
	}
}
