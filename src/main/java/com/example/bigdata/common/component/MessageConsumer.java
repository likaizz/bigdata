package com.example.bigdata.common.component;

import com.example.bigdata.common.annotation.MessageHandler;

public interface MessageConsumer {
    void consumeMessage(String msg);
    String topic() ;
    String key() ;
}
