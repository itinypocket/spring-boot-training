package com.songguoliang.configuration;

import com.songguoliang.shiro.RetryLimitCredentialsMatcher;
import com.songguoliang.shiro.UserRealm;
import com.songguoliang.shiro.cache.ShiroSpringCacheManager;
import com.songguoliang.shiro.captcha.DreamCaptcha;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-12 11:44
 */
@Configuration
public class ShiroConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfiguration.class);

    /**
     * 验证码
     *
     * @param shiroSpringCacheManager
     * @return
     */
    @Bean
    public DreamCaptcha dreamCaptcha(ShiroSpringCacheManager shiroSpringCacheManager) {
        DreamCaptcha dreamCaptcha = new DreamCaptcha(shiroSpringCacheManager);
        dreamCaptcha.setCacheName("halfHour");
        return dreamCaptcha;
    }

    /**
     * Shiro生命周期处理器
     *
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 凭证匹配器,密码错误5次锁定半小时
     *
     * @return
     */
    @Bean
    public RetryLimitCredentialsMatcher credentialsMatcher(ShiroSpringCacheManager shiroSpringCacheManager) {
        RetryLimitCredentialsMatcher credentialsMatcher = new RetryLimitCredentialsMatcher(shiroSpringCacheManager);
        credentialsMatcher.setRetryLimitCacheName("halfHour");
        //md5算法
        credentialsMatcher.setHashAlgorithmName("md5");
        //加密次数
        credentialsMatcher.setHashIterations(1);
        return credentialsMatcher;
    }

    /**
     * 用户授权信息Cache, 采用spring-cache
     *
     * @param cacheManager
     * @return
     */
    @Bean
    public ShiroSpringCacheManager shiroSpringCacheManager(CacheManager cacheManager) {
        ShiroSpringCacheManager shiroSpringCacheManager = new ShiroSpringCacheManager();
        shiroSpringCacheManager.setCacheManager(cacheManager);
        return shiroSpringCacheManager;
    }

    /**
     * 自定义realm
     *
     * @return
     */
    @Bean
    public UserRealm userRealm(ShiroSpringCacheManager shiroSpringCacheManager, RetryLimitCredentialsMatcher credentialsMatcher) {
        UserRealm userRealm = new UserRealm(shiroSpringCacheManager, credentialsMatcher);
        //启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        userRealm.setAuthenticationCachingEnabled(true);
        //缓存AuthenticationInfo信息的缓存名称
        userRealm.setAuthenticationCacheName("authenticationCache");
        //缓存AuthorizationInfo信息的缓存名称
        userRealm.setAuthorizationCacheName("authorizationCache");
        return userRealm;
    }

    /**
     * 安全管理器
     * 注：使用shiro-spring-boot-starter 1.4时，返回类型是SecurityManager会报错，直接引用shiro-spring则不报错
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(UserRealm userRealm, ShiroSpringCacheManager shiroSpringCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置自定义Realm
        securityManager.setRealm(userRealm);
        //将缓存管理器，交给安全管理器
        securityManager.setCacheManager(shiroSpringCacheManager);
        //记住密码管理器
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }


    /**
     * AOP式方法级权限检查
     *
     * @return
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * 开启shiro aop注解支持
     *
     * @param securityManager
     * @return
     */
    //@Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * shiro filter
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 设置登录的路径，如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登陆成功后跳转的url
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //没有权限跳转的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");

        // 过滤器链，拦截的顺序是按照配置的顺序来的
        // anon代表匿名的不需要拦截的资源,authc:认证通过才可以访问,user 认证通过和RememberMe登录都可以
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/captcha.jpg", "anon");
        filterChainDefinitionMap.put("/commons/**", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/**", "user");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 记住密码Cookie
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        //7天
        simpleCookie.setMaxAge(7 * 24 * 60 * 60);
        return simpleCookie;
    }

    /**
     * rememberMe管理器
     *
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(rememberMeCookie());
        rememberMeManager.setCipherKey(Base64.decode("5aaC5qKm5oqA5pyvAAAAAA=="));
        return rememberMeManager;
    }
}
