package com.dream.java.thread;

public class ThreadLocalTest extends Thread {

	private static ThreadLocal<Integer> seqCount = new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 0;
		}
	};

	public void run() {
		for (int i = 1; i < 3; i++) {
			
			seqCount.set(seqCount.get() +i);
			System.out.println(Thread.currentThread().getName() + ":" + seqCount.get());
		}
	}
}
