/**
 * Project:dream-tools-webapp
 * File:ScheduleTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *.		
 * @author nb
 * @date 2018年9月17日
 */
public class ScheduleTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService schedule =  (ScheduledExecutorService) Executors.newScheduledThreadPool(10);
		schedule.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println("111");
			}
		},1, 1, TimeUnit.SECONDS);
		schedule.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println("****");
			}
		},2, 2, TimeUnit.SECONDS);
		
		
		
		Thread.sleep(3000);
		System.out.println("222");
		Thread.sleep(3000);
		//schedule.shutdown();
		System.out.println("333");
		Thread.sleep(10000);
		System.out.println("444");
	}
	
	

}
