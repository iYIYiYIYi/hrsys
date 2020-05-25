package com.yihuang.hrsys.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * com.yihuang.hrsys.controller
 *
 * @author yihuang728
 * @create 2020/04/26
 */
public class LoginInterceptor implements HandlerInterceptor {

    /***
     * 在请求之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("username");
        if (!(loginUser instanceof String) || ((String) loginUser).isEmpty()) {
            // 未登录，重定向到登录页
//            response.sendRedirect("/");
            response.sendRedirect("/login");
            return false;
        }
        String userName = (String) loginUser;
        System.out.println("当前用户已登录，登录的用户名为： " + userName);
        return true;
    }

    /***
     * 在请求被处理后，视图渲染之前调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /***
     *
     * 在整个请求结束后调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
