package com.yihuang.hrsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * com.yihuang.hrsys.controller
 *
 * @author yihuang728
 * @create 2020/5/26
 */
@ControllerAdvice
//@Controller
public class ErrorController {

    @RequestMapping("/error")
    public ModelAndView error() {

        return new ModelAndView("404"){
            {
                addObject("errormsg","页面找不到了!");
            }
        };
    }

}
