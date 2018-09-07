package com.example.bigdata.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DemoService {
    public String sysGuid(){
        System.out.println(Thread.currentThread().getName()+"sysGuid");
        return UUID.randomUUID().toString();
    }
}
