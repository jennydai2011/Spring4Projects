package com.jdai.springbootjenkins.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/ride")
    public String getRide(){
        return "welcome, return ride";
    }
}
