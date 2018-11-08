/**
 * Project:dream-tools-webapp
 * File:UserService.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.patterns.proxy;

/**
 *.		
 * @author nb
 * @date 2018年10月17日
 */
public class UserService implements UserInterface{
	
	public void printUserName(String name) {
		System.out.println("干活之前----:" + name);
	}
}
