package com.javanight.spring.cloud.eureka.feign.client;

import com.javanight.spring.cloud.eureka.client.GreetingController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("eureka-service")
public interface GreetingClient extends GreetingController {

}
