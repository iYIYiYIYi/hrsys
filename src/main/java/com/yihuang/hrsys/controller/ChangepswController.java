package com.yihuang.hrsys.controller;

import com.yihuang.hrsys.entities.User;
import com.yihuang.hrsys.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * com.yihuang.hrsys.controller
 *
 * @author yihuang728
 * @create 2020/5/26
 */
@Controller
public class ChangepswController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/changeuserpwd/{username}/{password}")
    public ModelAndView changePassword(
            HttpSession session,
            @PathVariable(value = "username",required = true)String username,
            @PathVariable(value = "password",required = true)String password
    ) {
        String from  = (String) session.getAttribute("username");
        User fromUser = userService.findUser(from);
        if ((from != username) && (!fromUser.isRoot())) {
            return new ModelAndView("redirect:/login"){
                {
                    addObject("msg","你没有权限修改该用户的密码");
                }
            };
        }

        User user = userService.findUser(username);
        if (user == null) {
            ModelAndView modelAndView = new ModelAndView("/error");
            modelAndView.addObject("errormsg","用户不存在");
            return modelAndView;
        }
        userService.resetPwd(user,password);

        if (fromUser.isRoot()) {
            return new ModelAndView("redirect:/dashboard");
        }

        return new ModelAndView("redirect:/login?username="+username+"&password="+password);
    }

}
