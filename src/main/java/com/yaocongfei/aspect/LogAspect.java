package com.yaocongfei.aspect;  

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yaocongfei.pojo.User;

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
	
	@Pointcut("execution(* com.yaocongfei.service.*.*(..)) and args(..)")
    public void pointCutMethod() {  
    } 
	
	@After("pointCutMethod()")
	public void doAfter(){
		logger.info("=====AOP after=======");
	}
	
	@Before("pointCutMethod()")
	public void doBefore(JoinPoint jp){
		logger.info("=====AOP before======");
		Object[] args = jp.getArgs();
		System.out.println(args[0]);
		System.out.println(((User)args[0]).getUsername());
		System.out.println(((User)args[0]).getPassword());
		Signature signature = jp.getSignature();
		System.out.println(signature.toString());
		System.out.println(signature.toLongString());
		//打印结果：getUser
		System.out.println(signature.getName());
		//打印结果：接口名com.yaocongfei.service.UserService
		System.out.println(signature.getDeclaringTypeName());
		//打印结果：interface com.yaocongfei.service.UserService
		System.out.println(signature.getDeclaringType());
	}
	
//	@Around("pointCutMethod()")  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入方法---环绕通知");
        //表示让结束环绕前的一个通知信号，并且获取返回值
        Object o = pjp.proceed();
        User user = (User)o;
        user.setPassword("123456");
        //打印结果：com.yaocongfei.service.impl.UserServiceImpl@e9ccd5c
        System.out.println(pjp.getTarget());
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
 
