/**
 * Project:dream-tools-webapp
 * File:ClientTest.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.spring.webservice.service;

import java.rmi.RemoteException;

/**
 * @author nb
 * @date 2018年8月24日
 */
public class ClientTest {
	public static void main(String[] args) {
		ServiceClientTestProxy proxy = new ServiceClientTestProxy();
		ServiceClientTest clienttest = proxy.getServiceClientTest();
		try {
			String name = proxy.getName("21");
			System.out.println(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
