package com.songguoliang.controller;

import com.songguoliang.shiro.captcha.DreamCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-12 15:56
 */
@Controller
public class CommonsController {
    @Autowired
    private DreamCaptcha dreamCaptcha;

    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        dreamCaptcha.generate(request, response);
    }
}
