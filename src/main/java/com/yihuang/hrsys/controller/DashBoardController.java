package com.yihuang.hrsys.controller;

import com.yihuang.hrsys.entities.Department;
import com.yihuang.hrsys.entities.Employee;
import com.yihuang.hrsys.service.implement.DepartmentService;
import com.yihuang.hrsys.service.implement.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * com.yihuang.hrsys.controller
 *
 * @author yihuang728
 * @create 2020/5/15
 */
@Controller
public class DashBoardController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = {"/dashboard/{departmentID}/{employeeEID}","/dashboard/{departmentID}","/dashboard"})
    public ModelAndView dashboard(
            @PathVariable(value = "departmentID" , required = false) Long departmentID,
            @PathVariable(value = "employeeEID", required = false) Long employeeEID,
            HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("username",session.getAttribute("username"));

        String departmentName;
        List<Department> departments = departmentService.getAllDepartment();
        if (departmentID == null) {
            departmentName = departments.get(0).getDepartmentName();
            departmentID = departments.get(0).getDepartmentID();
        } else {
            departmentName = departmentService.getDepartment(departmentID).getDepartmentName();
        }
        Department D = departmentService.getDepartment(departmentID);
        modelAndView.addObject("departments",departments);
        modelAndView.addObject("departmentName",departmentName);
        modelAndView.addObject("department",D);
        modelAndView.addObject("currentdepartment",departmentID);

        List<Employee> employees = departmentService.getAllEmployee(departmentID);
        modelAndView.addObject("employees",employees);

        if (employeeEID == null && employees.size()>0) {
            employeeEID = employees.get(0).geteID();
        }
        if (employees.size() > 0) {
            Employee employee = employeeService.findEmployee(employeeEID);
            modelAndView.addObject("Employee",employee);

        } else {
            modelAndView.addObject("msgE","该部门没有员工");
        }

        Employee newEmployee = new Employee();
        modelAndView.addObject("newEmployee",newEmployee);

        modelAndView.addObject("Department",D);

        Department newDepartment = new Department();
        modelAndView.addObject("newDepartment",newDepartment);

        // ce -> certificate of employee
        session.setAttribute("ce",employeeEID);
        // nd -> Department Name
        session.setAttribute("nd",departmentID);

        return modelAndView;
    }

}
