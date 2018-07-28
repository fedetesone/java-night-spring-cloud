package com.javanight.spring.cloud.eureka.client1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication1 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication1.class, args);
    }
}
