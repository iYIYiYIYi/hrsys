package com.yihuang.hrsys.controller;

import com.yihuang.hrsys.entities.Employee;
import com.yihuang.hrsys.service.implement.DepartmentService;
import com.yihuang.hrsys.service.implement.EmployeeService;
import com.yihuang.hrsys.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * com.yihuang.hrsys.controller
 * 用户控制器，返回普通用户的视图
 * @author yihuang728
 * @create 2020/5/15
 */

@Controller
public class UserController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    /***
     * 返回普通用户的视图
     * @param session
     * @return
     */
    @RequestMapping(value = {"/","/index/{username}","/index"})
    public ModelAndView index(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (userService.findUser(username).isRoot()) {
            System.out.println("管理员即将跳转");
            return new ModelAndView("redirect:/dashboard");
        }

        Employee employee = employeeService.findEmployee(Long.parseLong(username));

        if (userService.findUser(username).isRoot()) {
            if (session.getAttribute("ce") != null && session.getAttribute("nd") != null) {
                return new ModelAndView("redirect:/dashboard/"
                        +session.getAttribute("nd")+"/"
                        +session.getAttribute("ce"));
            }
            return new ModelAndView("redirect:/dashboard");
        }

        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("Employee",employee);

        modelAndView.addObject("username",username);
        modelAndView.addObject("employee",employee);

        return modelAndView;
    }

}
