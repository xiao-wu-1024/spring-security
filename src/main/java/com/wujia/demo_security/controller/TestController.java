package com.wujia.demo_security.controller;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiao-_-wu
 * @date 2021/4/8 9:31
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/out/login")
    public String outLogin(){
        log.info("-----退出登录-----");
        return "out login";
    }

    @PostMapping("/login")
    public String loginSecurity(){
        return "login Security";
    }
    @GetMapping("/ok")
    public String helloSecurity(){
        log.info("-----登录成功-----");
        return "Hello Security";
    }
    @GetMapping("/remove")
    public String removeSecurity(){
        return "remove Security";
    }
}
