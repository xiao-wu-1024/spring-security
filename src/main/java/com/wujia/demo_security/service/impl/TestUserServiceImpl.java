package com.wujia.demo_security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wujia.demo_security.entity.TestUser;
import com.wujia.demo_security.mapper.TestUserMapper;
import com.wujia.demo_security.service.ITestUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表(TestUser)表服务实现类
 *
 * @author xiao_wu
 * @since 2021-04-08 17:05:42
 */
@Service("testUserService")
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements ITestUserService {
    @Resource
    private TestUserMapper testUserMapper;

    public static void main(String[] args) {

    }
}

