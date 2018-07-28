package com.javanight.spring.cloud.classic.client;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

@Controller
public class EurekaClientControllerImpl implements EurekaClientController {

    private final EurekaClient eurekaClient;

    @Autowired
    public EurekaClientControllerImpl(@Qualifier("eurekaClient") EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    public String greeting(Model model) {
        // Calling to Eureka Client 2.
        final Application application = eurekaClient.getApplication("spring-cloud-eureka-client-2");
        final InstanceInfo instanceInfo = application.getInstances().get(0);
        final String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();

        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<String> response = restTemplate.getForEntity(
                "http://" + hostname + ":" + port + "/greeting",
                String.class);

        if (HttpStatus.OK == response.getStatusCode()) {
            model.addAttribute("greeting", response.getBody());
        } else {
            model.addAttribute("error", response.getBody());
        }
        return "greeting-view";
    }
}
