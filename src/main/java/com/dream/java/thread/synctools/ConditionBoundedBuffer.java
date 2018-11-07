package com.dream.java.thread.synctools;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ning on 2018/11/7.
 */
public class ConditionBoundedBuffer <T>{
    protected final Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private int  tail,head,count;
    private final T[] items;

    public ConditionBoundedBuffer(int size) {
        items =  (T[]) new Object[size];
    }

    public void put(T v) throws InterruptedException {
        lock.lock();
        try{
            while(count == items.length)
                notFull.await();
            items[tail] = v;
            if(++tail == items.length)
                tail = 0;
            ++count;
            notEmpty.signal();

        }finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try{
            while(count == 0)
                notEmpty.await();
            T v = items[head];
            if(++head == items.length)
                head = 0;
            --count;
            notFull.signal();
            return v;
        }finally {
            lock.unlock();
        }
    }

}
