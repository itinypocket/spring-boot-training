package com.songguoliang.base;

import com.songguoliang.model.Result;
import com.songguoliang.shiro.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * controller基类
 *
 * @Author sgl
 * @Date 2018-04-11 18:21
 */
public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取当前登录用户对象
     * @return
     */
    public ShiroUser getShiroUser(){
        return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * ajax成功
     *
     * @return {Object}
     */
    public Object renderSuccess() {
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }
}
