package com.example.bigdata.service;

import com.example.bigdata.common.annotation.MessageHandler;
import com.example.bigdata.common.component.MessageConsumer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@MessageHandler(topic = "testcase", key = "origin")
@Component
public class OTestCaseMessageConsumer implements MessageConsumer {
    @PostConstruct
    public void init(){
        System.out.println("TestCaseMessageConsumer.init()");
    }
    @Async
    public void consumeMessage(String msg) {
        System.out.println("OTestCaseMessageConsumer.consumeMessage("+msg+")");
    }

    @Override
    public String topic() {
        return "testcase";
    }

    @Override
    public String key() {
        return "origin";
    }
}
