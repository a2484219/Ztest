package com.yaocongfei.concurrent;  

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * ���ܣ�
 * ���ߣ�lscm
 * ���ڣ�2016-6-7����2:38:30
 *
 */
public class MuiltThread {

	private ScheduledExecutorService scheduledExcutor = Executors.newScheduledThreadPool(20);
	
	public MuiltThread(){
		ExecutorService executorService = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
		MyThread mt = new MyThread();
		for(int i = 0; i < 1000; i++){
			scheduledExcutor.execute(mt);
		}
		scheduledExcutor.shutdown();
	}
	
	private class MyThread implements Runnable {

		private int i = 0;
		
		@Override
		public void run() {
			System.out.println(i++);
			
		}
		
	}
	
	public static void main(String[] args) {
		new MuiltThread();
	}
}
 
