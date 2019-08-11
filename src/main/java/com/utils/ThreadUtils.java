package com.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by mengxi on 2019/3/11.
 */
public class ThreadUtils {


    public static void main(String[] args) throws Exception {

        ExecutorService executorService =
                Executors.newCachedThreadPool();

        Future<?> submit = executorService.submit(() -> {
            for (int i = 0; i < 100000; i++) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        });


        Future<?> submit1 = executorService.submit(() -> {
            for (int i = 0; i < 100000; i++) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我没有执行哈");
                System.out.println(Thread.currentThread().getName() + "   " + i);
            }
        });


        //submit.get();


        for (int i = 0; i < 100000; i++) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }

        System.out.println("继续往下走了哈");
        //submit1.get();
        executorService.shutdown();
    }
}
