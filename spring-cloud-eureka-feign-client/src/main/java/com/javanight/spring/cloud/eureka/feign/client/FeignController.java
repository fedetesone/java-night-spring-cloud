package com.javanight.spring.cloud.eureka.feign.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeignController {
    private final GreetingClient greetingClient;

    @Autowired
    public FeignController(GreetingClient greetingClient) {
        this.greetingClient = greetingClient;
    }

    @RequestMapping("/get-greeting")
    public String greeting(Model model) {
        model.addAttribute("greeting", greetingClient.greeting());
        return "greeting-view";
    }
}
