package com.songguoliang.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-12 14:16
 */
public class MyShiroRealm extends AuthorizingRealm {

    /**
     * 授权：SimpleAuthorizationInfo用于存储用户的所有角色(Set<String> roles)和所有权限(Set<String> stringPermissions)信息
     * 当执行某个方法时，方法上会有权限注解，例如@RequiresPermissions("userInfo:add")，
     * 此时就会去找AuthorizationInfo中的stringPermissions是否包含userInfo:add，如果包含就继续处理，
     * 如果不包含则跳转到shiro配置的为授权的地址
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        return authorizationInfo;
    }

    /**
     * 认证
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     * 当用户登录时会执行
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        return null;
    }
}