package com.javanight.spring.cloud.eureka.feign;

import com.javanight.spring.cloud.eureka.feign.client.GreetingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class FeignControllerImpl implements FeignController {
    private final GreetingClient greetingClient;

    @Autowired
    public FeignControllerImpl(GreetingClient greetingClient) {
        this.greetingClient = greetingClient;
    }

    public String greeting(Model model) {
        model.addAttribute("greeting", greetingClient.greeting());
        return "greeting-view";
    }
}
