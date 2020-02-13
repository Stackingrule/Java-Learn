package com.mmall.concurrency.example.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample1 {

    private static final Logger logger = LoggerFactory.getLogger(SynchronizedExample1.class);

    // 修饰代码块
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                logger.info("test1 -{} {}", j, i);
            }
        }
    }

    // 修饰方法
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            logger.info("test2 -{} {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();

//        executorService.execute(() -> {
//            example1.test1();
//        });
//        executorService.execute(() -> {
//            example1.test1();
//        });

//        executorService.execute(() -> {
//            example1.test2();
//        });
//        executorService.execute(() -> {
//            example1.test2();
//        });

//        executorService.execute(() -> {
//            example1.test1(1);
//        });
//        executorService.execute(() -> {
//            example2.test1(2);
//        });

        executorService.execute(() -> {
            example1.test2(1);
        });
        executorService.execute(() -> {
            example2.test2(2);
        });
    }
}
