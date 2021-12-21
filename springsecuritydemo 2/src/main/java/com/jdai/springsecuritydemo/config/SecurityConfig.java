package com.jdai.springsecuritydemo.config;

import com.jdai.springsecuritydemo.handler.MyAccessDeniedHandler;
import com.jdai.springsecuritydemo.handler.MyAuthenticationFailureHandler;
import com.jdai.springsecuritydemo.handler.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单提交
        http.formLogin()
                .usernameParameter("username123")
                .passwordParameter("password123")
                //当发现请求endpoint匹配时，跳转到自定义登录页
                .loginProcessingUrl("/login")
                //自定义登录页面 --405 means POST not existed
                .loginPage("/login.html")
                //登录成功后跳转页面，必须是POST请求，只能forward,不能redirect
//                .successForwardUrl("/toMain")
//                .successForwardUrl("http://google.com")

                //登录成功转发页面，必须用successHandler,不能与successForwardUrl并存使用
                .successHandler(new MyAuthenticationSuccessHandler("http://google.com"))
                //登录失败后跳转页面，必须是POST请求
//                .failureForwardUrl("/toError")
                //登录失败转发页面，必须用failureHandler,不能与failureForwardUrl并存使用
                .failureHandler(new MyAuthenticationFailureHandler("http://baidu.com"))
        ;


        //拦截器 --授权认证
        http.authorizeRequests()
                //error.html 不需要认证
//                .antMatchers("/error.html").permitAll()
                .antMatchers("/error.html").access("permitAll()");
                //login.html 不需要认证
                .antMatchers("/login.html").permitAll()
                //.antMatchers("/main1.html").hasAnyAuthority("admin22")
                //.antMatchers("/main1.html").hasAnyRole("abc")
                .antMatchers("/main1.html").hasIpAddress("127.0.0.1")
                //拦截所有请求，所有请求必须认证
                .anyRequest().authenticated();

        //关闭防火墙
        http.csrf().disable();

        //异常处理
        http.exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);
    }
}
