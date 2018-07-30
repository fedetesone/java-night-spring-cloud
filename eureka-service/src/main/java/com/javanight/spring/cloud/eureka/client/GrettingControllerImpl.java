package com.javanight.spring.cloud.eureka.client;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingControllerImpl implements GreetingController {

    @Autowired
    @Qualifier("eurekaClient")
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    public String greeting() {
        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }

    public String test(@PathVariable String param1, long param2) {
        return String.format("Test from '%s' '%s'", param1, param2);
    }
}
