package com.songguoliang.shiro.captcha;

import com.songguoliang.util.StringUtils;
import com.songguoliang.util.WebUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 验证码
 * @Author sgl
 * @Date 2018-04-13 15:04
 */
public class DreamCaptcha implements InitializingBean {
    private final static Logger LOGGER = LoggerFactory.getLogger(DreamCaptcha.class);
    private static final String DEFAULT_COOKIE_NAME = "dream-captcha";
    private final static String DEFAULT_CHACHE_NAME = "dreamCaptchaCache";
    /**
     * cookie超时默认为session会话状态
     */
    private final static int DEFAULT_MAX_AGE = -1;

    private String cacheName;
    private String cookieName;
    private CacheManager cacheManager;

    private Cache<String, String> dreamCaptchaCache;

    public DreamCaptcha() {
        this.cacheName = DEFAULT_CHACHE_NAME;
        this.cookieName = DEFAULT_COOKIE_NAME;
    }

    public DreamCaptcha(CacheManager cacheManager) {
        this();
        this.cacheManager = cacheManager;
    }

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(cacheManager, "cacheManager must not be null!");
        Assert.hasText(cacheName, "cacheName must not be empty!");
        Assert.hasText(cookieName, "cookieName must not be empty!");
        this.dreamCaptchaCache = cacheManager.getCache(cacheName);
    }

    /**
     * 生成验证码
     *
     * @param request
     * @param response
     */
    public void generate(HttpServletRequest request, HttpServletResponse response) {
        // 先检查cookie的uuid是否存在
        String cookieValue = WebUtils.getCookieValue(request, cookieName);
        boolean hasCookie = true;
        if (StringUtils.isBlank(cookieValue)) {
            hasCookie = false;
            cookieValue = StringUtils.getUUId();
        }
        //转成大写重要
        String captchaCode = CaptchaUtils.generateCode().toUpperCase();
        // 不存在cookie时设置cookie
        if (!hasCookie) {
            WebUtils.setCookie(response, cookieName, cookieValue, DEFAULT_MAX_AGE);
        }
        // 生成验证码
        CaptchaUtils.generate(response, captchaCode);
        dreamCaptchaCache.put(cookieValue, captchaCode);
    }

    /**
     * 仅能验证一次，验证后立即删除
     *
     * @param request          HttpServletRequest
     * @param response         HttpServletResponse
     * @param userInputCaptcha 用户输入的验证码
     * @return 验证通过返回 true, 否则返回 false
     */
    public boolean validate(HttpServletRequest request, HttpServletResponse response, String userInputCaptcha) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("validate captcha userInputCaptcha is " + userInputCaptcha);
        }
        String cookieValue = WebUtils.getCookieValue(request, cookieName);
        if (StringUtils.isBlank(cookieValue)) {
            return false;
        }
        String captchaCode = dreamCaptchaCache.get(cookieValue);
        if (StringUtils.isBlank(captchaCode)) {
            return false;
        }
        // 转成大写重要
        userInputCaptcha = userInputCaptcha.toUpperCase();
        boolean result = userInputCaptcha.equals(captchaCode);
        if (result) {
            dreamCaptchaCache.remove(cookieValue);
            WebUtils.removeCookie(response, cookieName);
        }
        return result;
    }
}
