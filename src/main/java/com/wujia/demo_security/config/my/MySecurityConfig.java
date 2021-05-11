//package com.wujia.demo_security.config.my;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * 通过配置类实现自定义用户名
// * @author xiao-_-wu
// * @date 2021/4/8 15:03
// */
//@Configuration
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String password = passwordEncoder.encode("123");
//        auth.inMemoryAuthentication()
//                .withUser("wu-_-jia")
//                .password(password)
//                .roles("admin");
//    }
//
//    @Bean
//    PasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}
