package com.jdai.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile")
public class MobileController {
    /**
     * query cellphone number api
     * @return
     */
    @GetMapping("/query")
    public String query(){
        return "mobile";
    }
}
