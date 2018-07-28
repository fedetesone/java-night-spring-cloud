package com.javanight.spring.cloud.eureka.feign.client;

import com.javanight.spring.cloud.eureka.client1.GreetingController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("spring-cloud-eureka-client-2")
public interface GreetingClient extends GreetingController {
}
