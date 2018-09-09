package com.example.bigdata.controller;

import com.example.bigdata.common.utils.ApplicationContextUtil;
import com.example.bigdata.service.DemoService;
import com.example.bigdata.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("demo")
@PropertySource(value = "application-${spring.profiles.active}.properties")
public class DemoController {
    @Value("${batchSize}")
    private int batchSize;
    @Autowired
    private IDemoService service;
    @PostConstruct
    public void init(){
        System.out.println("batchSize="+batchSize);
    }

    @GetMapping("guid")
    public String guid() throws ExecutionException, InterruptedException {
//        return service.asyncSysGuid().get();
        return service.sysGuid();
    }

    @GetMapping("batchSize")
    public int batchSize(){
        return batchSize;
    }

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    {
    }
    @RequestMapping("msg")
    public void testSendMsg(String msg){
        kafkaTemplate.send("testcase",msg);
    }

}
