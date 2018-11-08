/**
 * Project:dream-tools-webapp
 * File:BufferTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.java.thread.synctools;

/**
 * .
 * @author nb
 * @date 2018年11月8日
 */
public class BufferTest {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ConditionBoundedBuffer<String> condition = new ConditionBoundedBuffer<String>(5);

		for (int i = 1; i < 4; i++) {
			PutThread putbuffer = new PutThread(condition);
			putbuffer.start();
		}

		Thread.sleep(10000);
		for (int i = 0; i < 8; i++) {
			TakeThread takebuffer = new TakeThread(condition);
			takebuffer.start();
		}
		for (int i = 1; i < 5; i++) {
			PutThread putbuffer = new PutThread(condition);
			putbuffer.start();
		}
		Thread.sleep(10000);
	}

	public static class PutThread extends Thread {

		private ConditionBoundedBuffer condition;

		/**
		 * @param condition2
		 */
		public PutThread(ConditionBoundedBuffer condition) {
			this.condition = condition;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void run() {
			try {
				condition.put(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static class TakeThread extends Thread {

		private ConditionBoundedBuffer condition;

		/**
		 * @param condition2
		 */
		public TakeThread(ConditionBoundedBuffer condition) {
			this.condition = condition;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void run() {
			try {
				String name = (String) condition.take();
				System.out.println("take:"+name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
