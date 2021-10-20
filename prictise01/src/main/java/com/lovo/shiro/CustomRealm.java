package com.lovo.shiro;

import com.lovo.bean.UserBean;
import com.lovo.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class CustomRealm extends AuthorizingRealm {
    @Resource
    private IUserService userInfoService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 身份认证的操作
        //1.获取用户输入的账号
        String username = (String) authenticationToken.getPrincipal();
        //2.通过username从数据库中查找到user实体
        UserBean userInfoBean = userInfoService.selectByName(username);
        if (userInfoBean == null) {
            return null;

        }
        //3.通过SimpleAuthenticationInfo做身份处理
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(userInfoBean, userInfoBean.getPwd(), getName());
        //4.返回身份处理对象
        return simpleAuthenticationInfo;

    }
}