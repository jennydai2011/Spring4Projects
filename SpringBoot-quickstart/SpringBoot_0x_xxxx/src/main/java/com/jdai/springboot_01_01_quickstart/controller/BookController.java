package com.jdai.springboot_01_01_quickstart.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById(){
        System.out.println("spring boot is running");
        return "SpringBoot_01_01-_quickstart";
    }
}
