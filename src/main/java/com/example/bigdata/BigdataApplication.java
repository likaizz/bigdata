package com.example.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration//必须要加次注解,不然运行初始化报错
@Configuration
public class BigdataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BigdataApplication.class, args);
		String[] beans = context.getBeanDefinitionNames();
		Arrays.sort(beans);
		for (String x : beans) {
			System.out.println(x);
		}
	}
}
