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
 * ���ܣ�
 * ���ߣ�lscm
 * ���ڣ�2016-5-27����2:42:57
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
		//��ӡ�����getUser
		System.out.println(signature.getName());
		//��ӡ������ӿ���com.yaocongfei.service.UserService
		System.out.println(signature.getDeclaringTypeName());
		//��ӡ�����interface com.yaocongfei.service.UserService
		System.out.println(signature.getDeclaringType());
	}
	
//	@Around("pointCutMethod()")  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("���뷽��---����֪ͨ");
        //��ʾ�ý�������ǰ��һ��֪ͨ�źţ����һ�ȡ����ֵ
        Object o = pjp.proceed();
        User user = (User)o;
        user.setPassword("123456");
        //��ӡ�����com.yaocongfei.service.impl.UserServiceImpl@e9ccd5c
        System.out.println(pjp.getTarget());
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
 
