package com.example.bigdata.service;

import com.example.bigdata.common.component.MessageConsumer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MTestCaseMessageConsumer implements MessageConsumer {
    @Async
    public void consumeMessage(String msg) {
        System.out.println("MTestCaseMessageConsumer.consumeMessage("+msg+")");
    }

    @Override
    public String topic() {
        return "testcase";
    }

    @Override
    public String key() {
        return "model";
    }
}
