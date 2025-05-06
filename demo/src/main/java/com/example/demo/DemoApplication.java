package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication // @SpringBootConfiguration 配置类 + @EnableAutoConfiguration 自动装配 + @ComponentScan 扫描包
@EnableDiscoveryClient // 注册到注册中心，并通过服务发现发现其他服务
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
