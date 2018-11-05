package com.dream.java.thread.synctools;

/**
 * Created by ning on 2018/11/5.
 */
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public BoundedBuffer(int size){
        super(size);
    }
    public synchronized void put(V v) throws InterruptedException {
        while (isFull())
            this.wait();
        doPut(v);
        notifyAll();
    }

     public synchronized  V take() throws InterruptedException {
        while (isEmpty())
            wait();
        V v = doTake();
        notifyAll();
        return v;
     }

}
