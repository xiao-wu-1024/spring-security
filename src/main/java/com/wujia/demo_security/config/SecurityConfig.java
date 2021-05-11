package com.wujia.demo_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author xiao-_-wu
 * @date 2021/4/8 15:30
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 设置权限不足访问页面
        httpSecurity.exceptionHandling().accessDeniedPage("/error.html");
        httpSecurity.formLogin()
                // 设置登录页面
                .loginPage("/login.html")
                // 登录访问路径
                .loginProcessingUrl("/test/login")
                // 登录成功后返回的跳转路径
                .defaultSuccessUrl("/test/ok").permitAll()

                .and().authorizeRequests()
                // 设置不需要登录验签的地址
                .antMatchers("/a/test/*", "/test/login").permitAll()
                // 设置路径访问权限, 单角色设置
                .antMatchers("/test/remove").hasRole("sss")
                // 多角色设置
//                .antMatchers().hasAnyRole("admin", "adminB")
                // 单权限设置
//                .antMatchers().hasAuthority("test")
                // 多权限设置
//                .antMatchers().hasAnyAuthority("test", "testB")
                // ip地址设置
//                .antMatchers().hasIpAddress("")
                .anyRequest()
                .authenticated()

                // 关闭csrf保护
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 设置白名单
     *
     * @return ret
     */
    private String[] whitelistUrl() {
        return new String[]{"/a/test/*", "/test/login"};
    }
}