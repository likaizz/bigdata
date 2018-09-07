package com.example.bigdata.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

public interface IDemoService {

    public String sysGuid();
    public Future<String> asyncSysGuid();
}
