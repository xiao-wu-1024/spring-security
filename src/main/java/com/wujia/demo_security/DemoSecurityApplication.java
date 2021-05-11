package com.wujia.demo_security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author wu_jia
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
@MapperScan("com.wujia.demo_security.mapper")
@SpringBootApplication
public class DemoSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityApplication.class, args);
    }

}
