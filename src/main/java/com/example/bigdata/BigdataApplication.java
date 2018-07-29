package com.example.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class BigdataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext iocContext=SpringApplication.run(BigdataApplication.class, args);
		String[]beanNames=iocContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String x:beanNames){
			Object obj=iocContext.getBean(x);
			System.out.println(obj.getClass()+":"+x);
		}
	}
}