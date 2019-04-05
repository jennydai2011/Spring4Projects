package com.jdai.diveIntoBoot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){ //方法名即 Bean 名称
        return "Hello world, spring boot";
    }
}
