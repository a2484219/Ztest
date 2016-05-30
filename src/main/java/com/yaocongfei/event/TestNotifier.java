package com.yaocongfei.event;  

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * 功能�?
 * 作�?：lscm
 * 日期�?016-5-30下午6:33:26
 *
 */
@Component
public class TestNotifier implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		//������ӡ3�Σ�һ������spring������ʼ����ʱ���ӡ��������Ǽ������Լ����¼�һ�Σ�����һ����spring��������
		System.out.println("Event����" + event);
		if(event instanceof TestEvent){
			System.out.println(((TestEvent) event).getAddress());
		}
	}

}
 
