package com.example.bigdata.service;

import com.example.bigdata.common.utils.ApplicationContextUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class DemoService implements IDemoService {
/*  //这里设置的自己注入自己没用
    private IDemoService demoService;

    @PostConstruct
    public void init() {
        demoService = ApplicationContextUtil.getApplicationContext().getBean(IDemoService.class);
        System.out.println(demoService);
    }*/


    @Async//("asyncTaskExecutor")
    public Future<String> asyncSysGuid() {
        System.out.println(Thread.currentThread().getName() + "asyncSysGuid");
        return new AsyncResult<String>(UUID.randomUUID().toString());
    }


    public String sysGuid() {
        System.out.println(Thread.currentThread().getName() + "sysGuid");
        try {
            Future<String> x = ApplicationContextUtil.getApplicationContext().getBean(IDemoService.class).asyncSysGuid();
            System.out.println("异步调用完成");
            return x.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
