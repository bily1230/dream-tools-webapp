package com.dream.java.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by ning on 2018/9/26.
 */
public class CompletionServiceTest {
    private final static ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);
        for(int i = 0 ;i <5 ; i++){
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Random random  = new Random();
                    int a = random.nextInt(6);
                    Thread.sleep(a*1000);
                    return String.valueOf(a);
                }
            });
        }
        System.out.println("2222222222");
        try {
        for(int i = 0; i<5;i++){
            Future<String> f = null;

                f = completionService.take();
                System.out.println(f.get());
        }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch(ExecutionException e){
            e.printStackTrace();
        }

    }
}
