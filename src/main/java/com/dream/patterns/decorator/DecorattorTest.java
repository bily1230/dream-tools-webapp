package com.dream.patterns.decorator;

public class DecorattorTest {
	
	public static void main(String[] args){
		
		AddComponent add = new AddComponent(new ComponentA());
		add.show();
	}
}
