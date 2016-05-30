package com.yaocongfei.event;  

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * 鍔熻兘锛?
 * 浣滆?锛歭scm
 * 鏃ユ湡锛?016-5-30涓嬪崍6:33:26
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
 
