package com.dream.patterns.decorator;

public class AddComponent extends ComponentDecorator{

	public AddComponent(Component component) {
		super(component);
	}
	
	@Override
	public void show() {
		super.show();
		System.out.println("age:"+12);
	}

}
