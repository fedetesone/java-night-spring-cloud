package com.javanight.spring.cloud.eureka.client1;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingControllerImpl implements GreetingController {

    private final EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    public GrettingControllerImpl(@Qualifier("eurekaClient") EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    public String greeting() {
        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }
}
