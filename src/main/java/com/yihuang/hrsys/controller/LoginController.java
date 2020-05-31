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
 * @author yihuang728
 * @create 2020/05/13
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/login"})
    public String login(Map<String,String> map,
                        HttpSession session,
                        @RequestParam(value = "username",required = false)String username,
                        @RequestParam(value = "password",required = false)String password) {


        if (username != null && password!=null && !"".equals(username)) {
            String logged = userService.login(username, password);
            System.out.println("logged:"+logged);
            if (!logged.isEmpty()) {
                session.setAttribute("username",username);
                return "redirect:/"+logged;
            } else {
                map.put("msg","用户名或密码错误");
            }
        }

        return "login";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.setAttribute("username",null);
        return "redirect:/login";
    }

}
