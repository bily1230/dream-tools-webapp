package com.dream.java.thread.synctools;

/**
 * Created by ning on 2018/11/5.
 */
public abstract class BaseBoundedBuffer<V> {
    private final V[] buf;
    private int tail;
private int head;
private int count;
protected  BaseBoundedBuffer(int capacity){
this.buf = (V[])new Object[capacity];
}
}
