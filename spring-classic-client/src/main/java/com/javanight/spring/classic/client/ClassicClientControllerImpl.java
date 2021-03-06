package com.javanight.spring.classic.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

@Controller
public class ClassicClientControllerImpl implements ClassicClientController {

    public String greeting(Model model) {
        final RestTemplate restTemplate = new RestTemplate();
        // Calling to Eureka Client 1 (that client is deployed in the port 9001).
        final ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:9002/greeting",
                String.class);

        if (HttpStatus.OK == response.getStatusCode()) {
            model.addAttribute("greeting", response.getBody());
        } else {
            model.addAttribute("error", response.getBody());
        }
        return "greeting-view";
    }

    public String test(Model model) {
        final RestTemplate restTemplate = new RestTemplate();
        // Calling to Eureka Client 1 (that client is deployed in the port 9001).
        final ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:9002/test/clasicClient?param2=1",
                String.class);

        if (HttpStatus.OK == response.getStatusCode()) {
            model.addAttribute("greeting", response.getBody());
        } else {
            model.addAttribute("error", response.getBody());
        }
        return "greeting-view";
    }

}
