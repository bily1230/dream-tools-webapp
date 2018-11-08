/**
 * Project:dream-tools-webapp
 * File:ThreadTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * .
 * @author nb
 * @date 2018年10月12日
 */
public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		final ContThread contThread = new ContThread();
		for (int i = 0; i < 3; i++) {
			Thread thread1 = new Thread(new Runnable() {
				public void run() {
					contThread.getName();
				}
			});
			thread1.start();
			
			Thread thread = new Thread(new Runnable() {
				public void run() {
					contThread.add();
				}
			});
			thread.start();
			
		}
		Thread.sleep(1000);
	

	}

	public static class ContThread {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		CountDownLatch downLatch = new CountDownLatch(4);

		public void add() {
			for (int i = 0; i < 3; i++) {
				atomicInteger.addAndGet(1);
				downLatch.countDown();
				System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
			}
			
		}

		public void getName() {
			try {
				downLatch.await();
				System.out.println(Thread.currentThread().getName() + "*****:" + atomicInteger.get());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
