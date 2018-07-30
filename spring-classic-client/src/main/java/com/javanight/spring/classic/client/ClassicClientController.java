package com.javanight.spring.classic.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ClassicClientController {
    @RequestMapping(method = RequestMethod.GET, value = "/get-greeting")
    String greeting(Model model);

    @RequestMapping(method = RequestMethod.GET, value = "/get-test")
    String test(Model model);
}
