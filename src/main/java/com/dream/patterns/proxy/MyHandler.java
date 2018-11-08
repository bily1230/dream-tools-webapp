/**
 * Project:dream-tools-webapp
 * File:MyHandler.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *.		
 * @author nb
 * @date 2018年10月17日
 */
public class MyHandler implements InvocationHandler {
	
	//目标对象
    private Object target;

    public MyHandler(Object target) {
        this.target = target;
    }
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("----代理前----");
		method.invoke(target, args);
		System.out.println("----代理后----");
		return null;
	}

}
