package com.yihuang.hrsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * com.yihuang.hrsys.controller
 *错误控制器，当前端出现访问异常时将返回此控制器
 * @author yihuang728
 * @create 2020/5/26
 */
@ControllerAdvice
public class ErrorController {

    @RequestMapping("/error")
    public ModelAndView error() {

        //返回 404.html模板文件
        return new ModelAndView("404"){
            {
                addObject("errormsg","页面找不到了!");
            }
        };
    }

}
