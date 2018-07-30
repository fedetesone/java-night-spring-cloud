package com.javanight.spring.cloud.eureka.feign;

import com.javanight.spring.cloud.eureka.feign.client.GreetingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class FeignControllerImpl implements FeignController {

    @Autowired
    private GreetingClient greetingClient;

    public String greeting(Model model) {
        model.addAttribute("greeting", greetingClient.greeting());
        return "greeting-view";
    }

    public String test(Model model) {
        model.addAttribute("greeting", greetingClient.test("feign", 3));
        return "greeting-view";
    }
}
