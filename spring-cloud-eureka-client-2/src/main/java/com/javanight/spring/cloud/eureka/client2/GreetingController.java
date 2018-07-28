package com.javanight.spring.cloud.eureka.client2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface GreetingController {
    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    String greeting();
}
