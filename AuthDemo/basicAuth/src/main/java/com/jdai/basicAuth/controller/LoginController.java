package com.jdai.basicAuth.controller;

import com.jdai.basicAuth.bean.UserBean;


import com.jdai.basicAuth.service.AuthService;
import com.jdai.basicAuth.util.MyConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/common/")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public UserBean login(UserBean loginUser, HttpServletRequest request){
        UserBean user= authService.userLogin(loginUser);
        if(null!=user){
            logger.info("user login succeed");
            request.getSession().setAttribute(MyConstants.FLAG_CURRENT_USER, user);

        }
        logger.info("user login failed");
        return user;
    }

    @PostMapping("/getCurrentUser")
    public Object getCurrentUser(HttpSession session){
        return session.getAttribute(MyConstants.FLAG_CURRENT_USER);
    }


    @PostMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute(MyConstants.FLAG_CURRENT_USER);
    }

}
