package com.dream.java.thread;

public class ThreadMain {

	public static void main(String[] args) {
		
		ThreadLocalTest test1 = new ThreadLocalTest();
		
		ThreadLocalTest test2 = new ThreadLocalTest();
		
		test1.start();
		test2.start();
	
	}

}
