package com.example.bigdata.controller;

import com.example.bigdata.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
@PropertySource(value = "application-${spring.profiles.active}.properties")
public class DemoController {
    @Value("${batchSize}")
    private int batchSize;
    @Autowired
    private DemoService service;

    @GetMapping("guid")
    public String guid(){
        return service.sysGuid();
    }

    @GetMapping("batchSize")
    public int batchSize(){
        return batchSize;
    }

}
