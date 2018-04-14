package com.songguoliang.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.songguoliang.model.Result;
import com.songguoliang.util.BeanUtils;
import com.songguoliang.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-14 09:50
 */
@Component
public class ExceptionResolver implements HandlerExceptionResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // log记录异常
        LOGGER.error(ex.getMessage(), ex);
        // 非控制器请求照成的异常
        if (!(handler instanceof HandlerMethod)) {
            return new ModelAndView("error/500");
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (WebUtils.isAjax(handlerMethod)) {
            Result result = new Result();
            result.setMsg(ex.getMessage());
            FastJsonJsonView view=new FastJsonJsonView();
            view.setContentType("text/html;charset=UTF-8");
            return new ModelAndView(view, BeanUtils.toMap(result));
        }

        return new ModelAndView("error/500").addObject("error", ex.getMessage());
    }
}
