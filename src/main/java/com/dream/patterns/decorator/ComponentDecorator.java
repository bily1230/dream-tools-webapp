package com.dream.patterns.decorator;

public class ComponentDecorator implements Component{
	
	private Component component;
	
	public ComponentDecorator(Component component) {
		this.component = component;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void show() {
		component.show();
	}

}
