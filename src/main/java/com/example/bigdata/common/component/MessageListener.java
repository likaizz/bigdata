package com.example.bigdata.common.component;

import com.example.bigdata.common.utils.ApplicationContextUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MessageListener {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    private ApplicationContextUtil applicationContextUtil;
    private Map<String,List<MessageConsumer>> msgConsumerMap=new ConcurrentHashMap<>();
    @PostConstruct
    public void init(){
        List<MessageConsumer>msgConsumers=applicationContextUtil.getBeanByType(MessageConsumer.class);
        for (MessageConsumer consumer:msgConsumers){
            String topic=consumer.topic();
            String key=consumer.key();
            List<MessageConsumer>list=msgConsumerMap.get(topic);
            if(CollectionUtils.isEmpty(list)){
                list=new ArrayList<>();
                msgConsumerMap.put(topic,list);
            }
            list.add(consumer);
        }
    }

    @KafkaListener(topics = "testcase")
    public void listenMessage(ConsumerRecord<String, String> record){
        String topic=record.topic();
        String key=record.key();
        List<MessageConsumer>list=msgConsumerMap.get(topic);
        if(CollectionUtils.isEmpty(list))return;
        for(MessageConsumer consumer:list){
            if(StringUtils.isEmpty(key)||key.contains(consumer.key())){
                consumer.consumeMessage(record.value());
            }
        }
    }
}
