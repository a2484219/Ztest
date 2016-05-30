package com.yaocongfei.event;  

import org.springframework.context.ApplicationEvent;

/**
 *
 * 功能：
 * 作者：lscm
 * 日期：2016-5-30下午6:28:30
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
 
