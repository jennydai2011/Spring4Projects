package com.jdai.springboot_01_01_quickstart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class WebTest {

    @Test
    public void testGet(@Autowired MockMvc mvc){
        RequestBuilder builder = new RequestBuilder();
    }
}
