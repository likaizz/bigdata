package com.example.bigdata.task;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool= Executors.newFixedThreadPool(4);
        List<String> list=new ArrayList<>();
        List<Future<String> > futures=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Callable<String> future=new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(RandomUtils.nextInt(1000,5000));
                    if(Math.random()<0.6)throw new RuntimeException("ex");
                    return UUID.randomUUID().toString();
                }
            };
            Future<String> result=pool.submit(future);
            futures.add(result);
        }


        long s=System.currentTimeMillis();
//        System.out.println(result.get());
        for (int i = 0; i < futures.size(); i++) {
            String x =null;
            try {
                 x = futures.get(i).get();
            }catch (Exception ex){
                ex.printStackTrace();
            }
            System.out.println(x);
        }
        long e=System.currentTimeMillis();
        System.out.println(e-s);
    }
}
