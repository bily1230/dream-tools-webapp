package com.dream.java.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTest {

	public static void main(String[] args) {
		String fromPath = "/home/nb/桌面/xmind-pro-8-linux.zip";
		String bufferPath = "/home/nb/桌面/方向.docx";
		String toPath = "/home/nb/桌面/zz";

		long start = System.currentTimeMillis();
		ioTest(fromPath, toPath);
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		long bufferStart = System.currentTimeMillis();
		nioTest(bufferPath, toPath);
		long bufferEnd = System.currentTimeMillis();
		System.out.println(bufferEnd - bufferStart);

	}

	public static void ioTest(String fromPath, String toPath) {

		File fromFile = new File(fromPath);
		if (!fromFile.exists()) {
			return;
		}
		String fileName = fromFile.getName();
		toPath = toPath + File.separator + fileName;
		File toFile = new File(toPath);
		if (!toFile.exists()) {
			new File(toFile.getParent()).mkdirs();
		}
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(toFile));
			in = new BufferedInputStream(new FileInputStream(fromFile));
			byte[] buf = new byte[1024];
			int b = 0;
			while ((b = in.read(buf)) > 0) {
				out.write(buf, 0, b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void nioTest(String fromPath, String toPath) {
		File fromFile = new File(fromPath);
		if (!fromFile.exists()) {
			return;
		}
		String fileName = fromFile.getName();
		toPath = toPath + File.separator + fileName;
		File toFile = new File(toPath);
		if (!toFile.exists()) {
			new File(toFile.getParent()).mkdirs();
		}

		try {
			FileChannel outChannel = new FileOutputStream(toFile).getChannel();
			FileChannel inChannel = new FileInputStream(fromFile).getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int b = -1;
			while ((b = inChannel.read(buffer)) > 0) {
				buffer.flip();
				outChannel.write(buffer);
				buffer.clear();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}

}
