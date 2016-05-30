package com.yaocongfei.aspect;  

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;


/**
 *
 * 功能：
 * 作者：lscm
 * 日期：2016-5-27下午2:42:57
 *
 */
@Aspect
@Component
public class LogAspect {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(LogAspect.class);
	
	@Pointcut("execution(* com.yaocongfei.service.*.*(..))")
    public void pointCutMethod() {  
    } 
	
	@After("pointCutMethod()")
	public void doAfter(){
		logger.info("=====after=======");
		System.out.println("=========AOP方法后执行=========");
	}
	
	@Before("pointCutMethod()")
	public void doBefore(){
		logger.info("=====before======");
		System.out.println("=========AOP方法前执行=========");
	}
	
	@Around("pointCutMethod()")  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入方法---环绕通知");
        Object o = pjp.proceed();
        System.out.println("退出方法---环绕通知");
        return o;
    }  
	
	//声明后置通知  
    @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
    public void doAfterReturning(String result) {
        System.out.println("后置通知");
        System.out.println("---" + result + "---");
    }  
  
    //声明例外通知  
    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        System.out.println("例外通知");
        System.out.println(e.getMessage());
    }  
}
 
