package com.javanight.spring.classic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Controller
public class ClassicClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassicClientApplication.class, args);
    }

    @RequestMapping("/get-greeting")
    public String greeting(Model model) {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:9001/greeting",
                String.class);

        if (HttpStatus.OK == response.getStatusCode()) {
            model.addAttribute("greeting", response.getBody());
        } else {
            model.addAttribute("error", response.getBody());
        }
        return "greeting-view";
    }
}
