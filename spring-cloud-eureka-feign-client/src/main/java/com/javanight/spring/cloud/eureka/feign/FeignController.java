package com.javanight.spring.cloud.eureka.feign;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface FeignController {
    @RequestMapping(method = RequestMethod.GET, value = "/get-greeting")
    String greeting(Model model);
}
