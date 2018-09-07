package com.example.bigdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        String threadName=Thread.currentThread().getName();
        System.out.println(threadName+":invokeMetod");
//        if(Math.random()<0.75)throw new RuntimeException("李凯myException");
        Thread.sleep(10000);
        System.out.println("invokeMetod成功");
        return "李凯hello";
    }
}
