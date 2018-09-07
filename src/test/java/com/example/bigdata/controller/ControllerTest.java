package com.example.bigdata.controller;

import com.example.bigdata.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ControllerTest extends AbstractTest {
    @Autowired
    private HelloController helloController;

    @Test
    public void test() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch sign = new CountDownLatch(2);
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    System.out.println("异步开始");
                    helloController.hello();
                    System.out.println("异步结束");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + ":" + e.getMessage());
                } finally {
                    System.out.println("finally");
                    sign.countDown();
                }
            }
        };
        Future future = pool.submit(runnable);
//        pool.submit()
        try {
            future.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception ex) {
            ex.printStackTrace();
            future.cancel(true);
        }
        sign.await();

    }
}
