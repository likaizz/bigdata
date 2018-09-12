package com.example.bigdata.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;

@Configuration
public class ExecutorPoolConfig {
    @Bean("asyncTaskExecutor")
    public AsyncTaskExecutor asyncTaskExecutor(){
        ThreadPoolTaskExecutor poolTaskExecutor=new ThreadPoolTaskExecutor();
        poolTaskExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        return poolTaskExecutor;
    }
}
