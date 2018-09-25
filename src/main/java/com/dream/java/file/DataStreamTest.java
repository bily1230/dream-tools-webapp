package com.dream.java.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {

	public static void main(String[] args) {

		System.out.println("sssss");
		try {
		  File file = new File("/home/nb/桌面/test.txt");
		  System.out.println("xxx");
			if (file != null) {
				System.out.println("yyyy");
				DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				out.writeDouble(3.22222);
			
				out.close();
				
				DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
				System.out.println(in.readDouble());
				in.close();
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("sssss11");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("sssss22");
			e.printStackTrace();
		}
		
	}
	
	
}
