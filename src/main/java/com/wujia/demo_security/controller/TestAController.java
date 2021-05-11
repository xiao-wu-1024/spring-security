package com.wujia.demo_security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiao-_-wu
 * @date 2021/4/9 14:03
 */
@Slf4j
@RestController
@RequestMapping("/a/test")
public class TestAController {

    @GetMapping("/login")
    public String loginSecurity(){
        return "login Security";
    }
    @GetMapping("/ok")
    public String helloSecurity(){
        return "ok Security";
    }
    @GetMapping("/remove")
    public String removeSecurity(){
        return "remove Security";
    }
}
