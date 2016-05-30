package com.yaocongfei.util;  

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * 功能：
 * 作者：lscm
 * 日期：2016-5-30下午6:21:06
 *
 */
@Component
public class ApplicationUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		
		this.applicationContext = applicationContext;
		
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public final static Object getBean(String beanName) {
		
		return applicationContext.getBean(beanName);
	}
	
	public final static Object getBean(String beanName, Class<?> requiredType) {
		
		return applicationContext.getBean(beanName, requiredType);
	}
}
 
