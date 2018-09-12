package com.example.bigdata.service;

import com.example.bigdata.common.component.MessageConsumer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class DiDefectMsgConsumer implements MessageConsumer{
    @Async
    public void consumeMessage(String msg) {
        System.out.println("DiDefectMsgConsumer.consumeMessage("+msg+")");
    }

    @Override
    public String topic() {
        return "defect";
    }

    @Override
    public String key() {
        return "origin";
    }
}
