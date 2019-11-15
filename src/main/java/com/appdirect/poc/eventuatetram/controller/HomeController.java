package com.appdirect.poc.eventuatetram.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "Hello";
    }
}
