/**
 * Project:dream-tools-webapp
 * File:ProxyTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.patterns.proxy;

import java.lang.reflect.Proxy;

/**
 *.		
 * @author nb
 * @date 2018年10月17日
 */
public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 UserService user = new UserService();
		 MyHandler myHandler = new MyHandler(user);
		 UserInterface userProxy = (UserInterface) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserInterface.class},myHandler);
		 userProxy.printUserName("yyyyyyyyyyyy");
	}

}
