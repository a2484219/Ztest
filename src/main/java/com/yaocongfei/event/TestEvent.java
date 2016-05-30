package com.yaocongfei.event;  

import org.springframework.context.ApplicationEvent;

/**
 *
 * ���ܣ�
 * ���ߣ�lscm
 * ���ڣ�2016-5-30����6:28:30
 *
 */
public class TestEvent extends ApplicationEvent {

	private String address;
	
	public TestEvent(String address) {
		super(address);
		this.address = address;
	}

	public String getAddress(){
		return address;
	}
	
}
 
