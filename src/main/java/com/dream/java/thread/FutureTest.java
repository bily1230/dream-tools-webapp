package com.dream.java.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by ning on 2018/9/25.
 */
public class FutureTest {
    private final static ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        Callable<List<String>> task = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                  Thread.sleep(5000);
                  System.out.println(Thread.currentThread().getName());
                  return Arrays.asList("11","22");

           }
        };
        Future<List<String>> future = executorService.submit(task);
        Callable<List<String>> task2 = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
                return Arrays.asList("44","55");

            }
        };
        Future<List<String>> future2 = executorService.submit(task2);
        List<String> list = null;
        List<String> list2 = null;
        System.out.println(Thread.currentThread().getName());
        try {
            list = future.get();
            list2 = future2.get();
            for(String str : list){
                System.out.println("--"+str);
            }
            for(String str : list2){
                System.out.println("**"+str);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("122222");


    }
}



