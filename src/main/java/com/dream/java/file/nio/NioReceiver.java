package com.dream.java.file.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioReceiver {
	
	public static void main(String[] args) throws IOException{
		ByteBuffer echoBuffer = ByteBuffer.allocate(100);
		ServerSocketChannel ssc = ServerSocketChannel.open();
		Selector selector = Selector.open();
		ssc.configureBlocking(false);
		ServerSocket ss = ssc.socket();
		InetSocketAddress address = new InetSocketAddress(8080);
		ss.bind(address);
		SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("开始监听…………");
		while(true){
			int num = selector.select();
			Set selectdKeys = selector.selectedKeys();
			Iterator it = selectdKeys.iterator();
			while(it.hasNext()){
				SelectionKey sKey = (SelectionKey)it.next();
				SocketChannel channel = null;
				if(sKey.isAcceptable()){
					ServerSocketChannel sc = (ServerSocketChannel)key.channel();
					channel = sc.accept();
					channel.configureBlocking(false);
					channel.register(selector, SelectionKey.OP_READ);
					it.remove();
				}else if(sKey.isReadable()){
					channel = (SocketChannel) sKey.channel();  
                    while (true) {  
                        echoBuffer.clear();  
                        int r = channel.read(echoBuffer);  
                        if (r <= 0) {  
                            channel.close();  
                            System.out.println("接收完毕，断开连接");  
                            break;  
                        }  
                        System.out.println("##" + r + " " + new String(echoBuffer.array(), 0, echoBuffer.position()));  
                        echoBuffer.flip();  
                    }  
                    it.remove();  
				}else{
					channel.close();
				}
			}
			
		}
	}
}
