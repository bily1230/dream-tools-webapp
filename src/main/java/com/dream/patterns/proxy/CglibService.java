/**
 * Project:dream-tools-webapp
 * File:CglibService.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.patterns.proxy;

/**
 *.		
 * @author nb
 * @date 2018年10月18日
 */
public class CglibService {
	public String printUserName(String name) {
		System.out.println("干活之前----:" + name);
		return name;
	}
}
