package com.example.bigdata.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-1)
public class ApplicationContextUtil implements ApplicationContextAware {
    
    private static ApplicationContext applicationContext;

    public void setApplicationContext(@Autowired ApplicationContext ac)
            throws BeansException {
        applicationContext = ac;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
    /**
     * 根据Class类型在IOC容器中获取对象
     * @param clazz Class类型
     * @return 对象
     */
    public static <T> List<T> getBeanByType(Class<T> clazz) {
        List<T> list = new ArrayList<T>();
        
        /* 获取接口的所有实例名 */
        String[] beanNames = applicationContext.getBeanNamesForType(clazz);
        System.out.println("getBeanByType beanNames : " + beanNames == null ? "" : Arrays.toString(beanNames));
        
        if (beanNames == null || beanNames.length == 0) {
            return list;
        }
        
        T t = null;
        for (String beanName : beanNames) {
            t = (T)applicationContext.getBean(beanName);
            list.add(t);
        }
        return list;
    }

}