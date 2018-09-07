package com.example.bigdata.common.aop;

import com.example.bigdata.dao.oracle.OraMyMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//@Component
//@Aspect
public class DaoMonitorAop {

        @Around("execution(* com.example.bigdata.dao.oracle.OraMyMapper.*(..))")
        @Order(-1)
        public Object aopHandler(ProceedingJoinPoint pjp)
            throws Throwable {

            MethodSignature signature = (MethodSignature) pjp.getSignature();
            Method method = signature.getMethod(); //获取被拦截的方法

            String methodName = method.getName(); //获取被拦截的方法名


            long t1 = System.currentTimeMillis();
            Object val = pjp.proceed();//目标业务方法
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;

            //JoinPoint 对象可以获取目标业务方法的
            //详细信息: 方法签名, 调用参数等
            Signature m = pjp.getSignature();
            //Signature: 签名, 这里是方法签名
            System.out.println("test1:"+m + "用时:" + t);
            return val;
        }
}

