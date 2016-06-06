package com.yaocongfei.event;  

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * 功能：
 * 作者：lscm
 * 日期：2016-5-30下午6:28:30
 *
 */
@Component
public class TestNotifier implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		//这里会打印3次，一次是在spring容器初始化的时候打印，另外就是监听到自己的事件一次，还有一次是spring容器销毁
		System.out.println("Event对象：" + event);
		if(event instanceof TestEvent){
			System.out.println(((TestEvent) event).getAddress());
		}
	}

}
 
