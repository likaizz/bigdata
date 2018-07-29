package com.example.bigdata.common.aop;

import com.example.bigdata.common.annotation.MultiTransactional;
import com.example.bigdata.common.utils.ApplicationContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.lang.reflect.Method;

//@Aspect
//@Component
public class MultiTransactionalHandler {
//	@Pointcut("execution(* com.example.bigdata.service.*(..)) && @annotation(com.example.bigdata.common.annotation.MultiTransactional)")
//	public void controllerMethodPointcut(){}

    @Around("execution(* com.example.bigdata.service.*(..)) && @annotation(com.example.bigdata.common.annotation.MultiTransactional)")
    public Object test(ProceedingJoinPoint pjp)
            throws Throwable {
//        Signature signature=pjp.getSignature();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        MultiTransactional anno = method.getAnnotation(MultiTransactional.class);
        String[] txs = anno.value();

        ApplicationContext iocContext = ApplicationContextUtil.getApplicationContext();
//        for (String txName : txs) {
//            PlatformTransactionManager tx=iocContext.getBean(txName, PlatformTransactionManager.class);
//            tx.getTransaction();
//        }

        String methodName = method.getName(); //获取被拦截的方法名


        long t1 = System.currentTimeMillis();
        Object val = pjp.proceed();//目标业务方法
        long t2 = System.currentTimeMillis();
        long t = t2 - t1;

        //JoinPoint 对象可以获取目标业务方法的
        //详细信息: 方法签名, 调用参数等
        Signature m = pjp.getSignature();
        //Signature: 签名, 这里是方法签名
        System.out.println(m + "用时:" + t);
        return val;
    }

}
