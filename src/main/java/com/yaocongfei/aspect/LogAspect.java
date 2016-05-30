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
 * ���ܣ�
 * ���ߣ�lscm
 * ���ڣ�2016-5-27����2:42:57
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
		System.out.println("=========AOP������ִ��=========");
	}
	
	@Before("pointCutMethod()")
	public void doBefore(){
		logger.info("=====before======");
		System.out.println("=========AOP����ǰִ��=========");
	}
	
	@Around("pointCutMethod()")  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("���뷽��---����֪ͨ");
        Object o = pjp.proceed();
        System.out.println("�˳�����---����֪ͨ");
        return o;
    }  
	
	//��������֪ͨ  
    @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
    public void doAfterReturning(String result) {
        System.out.println("����֪ͨ");
        System.out.println("---" + result + "---");
    }  
  
    //��������֪ͨ  
    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        System.out.println("����֪ͨ");
        System.out.println(e.getMessage());
    }  
}
 
