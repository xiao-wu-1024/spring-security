package com.wujia.demo_security.config.impl;

import com.wujia.demo_security.consts.CommonConst;
import com.wujia.demo_security.consts.CommonEnum;
import com.wujia.demo_security.entity.TestUser;
import com.wujia.demo_security.service.ITestUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiao-_-wu
 * @date 2021/4/8 15:37
 */
@Slf4j
@Service("userDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private ITestUserService userService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        TestUser userEntity = loginProgram(account);
        List<GrantedAuthority> grantedAuthorities = loginRole(1);
        return new User(userEntity.getAccount(), userEntity.getPassword(), grantedAuthorities);
    }

    /**
     * 登录角色
     * @param role 角色
     * @return ret
     */
    private List<GrantedAuthority> loginRole(Integer role) {
        String authorityString = "";
        switch (role) {
            case CommonConst.USER_ROLE:
                authorityString = CommonEnum.USER_ROLE.getMessage();
                break;
            case CommonConst.ADMIN_ROLE:
                authorityString = CommonEnum.ADMIN_ROLE.getMessage();
                break;
            default:
                throw new UsernameNotFoundException("用户信息异常");
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorityString);
    }

    /**
     * 用户登录程序
     * @param account 账户
     * @return ret
     */
    private TestUser loginProgram(String account){
        TestUser userEntity = userService.lambdaQuery()
                .eq(TestUser::getAccount, account)
                .eq(TestUser::getAccountStatus, 0)
                .one();
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户账号不存在,或已冻结");
        }
        userEntity.setPassword(new BCryptPasswordEncoder()
                .encode(userEntity.getPassword()));
        return userEntity;
    }
}
