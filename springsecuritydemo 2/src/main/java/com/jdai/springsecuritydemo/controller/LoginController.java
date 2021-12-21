package com.jdai.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

//    @GetMapping("login")
//    public String login(){
//        System.out.println("登录成功");
//        return "redirect:main.html";
//    }

    @PostMapping("toMain")
    public String toMain(){
        System.out.println("登录成功");
        return "redirect:main.html";
    }

    @PostMapping("toError")
    public String toError(){
        System.out.println("登录失败");
        return "redirect:error.html";
    }
}
