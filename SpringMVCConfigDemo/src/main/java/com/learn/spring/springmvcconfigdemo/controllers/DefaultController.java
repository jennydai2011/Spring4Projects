/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.spring.springmvcconfigdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tony
 */
@Controller
public class DefaultController {
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(ModelMap map){
        map.put("msg", "Hello Spring 4 Web MVC no xml config!");
        return "index";
    }
    
}
