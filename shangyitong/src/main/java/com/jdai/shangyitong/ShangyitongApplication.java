package com.jdai.shangyitong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jdai.shangyitong.mapper")
public class ShangyitongApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShangyitongApplication.class, args);
    }

}
