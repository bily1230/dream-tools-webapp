package com.dream.java.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedBuffer {
	
	static int length = 0x8000000;
	
	public static void main(String[] args) throws IOException {
		
		FileChannel fc = new RandomAccessFile("/home/nb/桌面/方向.docx", "rw").getChannel();
		
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++) {
			mbb.put((byte) 'x');
        }
	
        System.out.println("Finished writing");
        //读取文件中间6个字节内容
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.print((char) mbb.get(i));
        }
        fc.close();
		
	}

}
