/**
 * Project:dream-tools-webapp
 * File:CglibTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.patterns.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *.		
 * @author nb
 * @date 2018年10月18日
 */
public class CglibTest {
	public static void main(String[] args) {
		   Enhancer enhancer = new Enhancer();
		   enhancer.setSuperclass(CglibService.class);
		  /* enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				    System.out.println("before method run...");	
				    Object result = proxy.invokeSuper(obj, args);
	                System.out.println("after method run...");
	                return result;
			}
		   });*/
		   enhancer.setCallback(new MethodInterceptor() {

				@Override
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					    System.out.println("before method run...");	
					    Object result = proxy.invokeSuper(obj, args);
		                System.out.println("after method run...");
		                return result;
				}
			   });
		   CglibService proxy = (CglibService) enhancer.create();
		  System.out.println(proxy.printUserName("小王"));
	}
}
