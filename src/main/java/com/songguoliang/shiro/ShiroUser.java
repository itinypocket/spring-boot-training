package com.songguoliang.shiro;

import java.io.Serializable;
import java.util.Set;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @Author sgl
 * @Date 2018-04-12 10:50
 */
public class ShiroUser implements Serializable {
    private static final long serialVersionUID = 6051885928604031814L;
    private Long id;
    private String loginName;
    private String name;
    private Set<String> urls;
    private Set<String> roles;

    public ShiroUser(String loginName) {
        this.loginName = loginName;
    }

    public ShiroUser(Long id, String loginName, String name, Set<String> urls, Set<String> roles) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.urls = urls;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     * @return
     */
    @Override
    public String toString() {
        return this.loginName;
    }
}
