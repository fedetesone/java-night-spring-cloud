package com.javanight.spring.cloud.eureka.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface GreetingController {
    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    String greeting();

    @RequestMapping(method = RequestMethod.GET, value = "/test/{param1}", params = "param2")
    String test(@PathVariable("param1") String param1, @RequestParam("param2") long param2);
}
