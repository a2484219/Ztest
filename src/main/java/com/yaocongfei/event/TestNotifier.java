package com.yaocongfei.event;  

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * åŠŸèƒ½ï¼?
 * ä½œè?ï¼šlscm
 * æ—¥æœŸï¼?016-5-30ä¸‹åˆ6:33:26
 *
 */
@Component
public class TestNotifier implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("Event¶ÔÏó£º" + event);
		if(event instanceof TestEvent){
			System.out.println(((TestEvent) event).getAddress());
		}
	}

}
 
