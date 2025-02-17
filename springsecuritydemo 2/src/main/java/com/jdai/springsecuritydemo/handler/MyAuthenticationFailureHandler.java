package com.jdai.springsecuritydemo.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private String url;
    public MyAuthenticationFailureHandler() {
    }

    public MyAuthenticationFailureHandler(String url) {
        this.url = url;
    }

    @Override

    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //handle exception
        httpServletResponse.sendRedirect(url);
    }
}
