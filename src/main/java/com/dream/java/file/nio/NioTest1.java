package com.dream.java.file.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ning on 2018/4/16.
 */
public class NioTest1 {

    public static void main(String[] args){

        try {


            FileChannel fcIn = new FileInputStream("C:\\Users\\ning\\Desktop\\学习.txt").getChannel();


            FileChannel fcOut = new  FileOutputStream("C:\\Users\\ning\\Desktop\\aa.txt").getChannel();


            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fcIn.read(buffer)!=-1){
                buffer.flip();
                fcOut.write(buffer);
                buffer.clear();
            }



            fcOut.close();
            System.out.println("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
