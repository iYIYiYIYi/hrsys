package com.yihuang.hrsys.controller;

import com.yihuang.hrsys.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * com.yihuang.hrsys.controller
 * Login controller , handle login users
 * 登陆控制器，检测用户权限，分权限跳转
 * @author yihuang728
 * @create 2020/05/13
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /***
     * 登录页面，根据不同的用户权限跳转到不同的界面
     * @param map
     * @param session
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value={"/login"})
    public String login(Map<String,String> map,
                        HttpSession session,
                        @RequestParam(value = "username",required = false)String username,
                        @RequestParam(value = "password",required = false)String password) {


        if (username != null && password!=null && !"".equals(username)) {
            //login方法实现了对用户的权限跳转，权限不同所返回的跳转地址不通
            String logged = userService.login(username, password);
            System.out.println("logged:"+logged);
            if (!logged.isEmpty()) {
                //将用户名存入session，以便于后续的身份判断
                session.setAttribute("username",username);
                return "redirect:/"+logged;
            } else {
                map.put("msg","用户名或密码错误");
            }
        }

        return "login";
    }

    /***
     *退出登录，清除session，并跳转到登陆页面
     * @param session
     * @return
     */
    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.setAttribute("username",null);
        return "redirect:/login";
    }

}
