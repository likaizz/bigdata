package com.example.bigdata.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class FinalAfterAspect {
//    private ThreadLocal<String>sign=new ThreadLocal<String>();

//    @Before("ControllerInterceptor.controllerMethodPointcut()")
    public void firstBefore(JoinPoint joinPoint){
        String threadName=Thread.currentThread().getName();
//        System.out.println(threadName+":firstBefore:"+sign.get());
    }


//    @After("ControllerInterceptor.controllerMethodPointcut()")
    public void finalAfter(JoinPoint joinPoint){
        String threadName=Thread.currentThread().getName();
//        System.out.println(threadName+":finalAfter:"+sign.get());
//        sign.remove();
    }
}
