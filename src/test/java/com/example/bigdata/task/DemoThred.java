package com.example.bigdata.task;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ConfigurationProperties
public class DemoThred {
    public static void main(String[] args) {
        ExecutorService pool= Executors.newCachedThreadPool();
        final List<Thread> thread = new ArrayList<>();
        Runnable runnable=new Runnable() {
            public void run() {
                thread.add(Thread.currentThread());
                try {
                    Thread.sleep(10000);
                 } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+":"+e.getMessage());
                }
            }
        };
        pool.execute(runnable);
        while(true){
            if(thread.size()==0)continue;
            Thread t=thread.get(0);
            boolean flag=t.isInterrupted();
            System.out.println(flag);
            t.interrupt();
            break;
        }



    }
}
