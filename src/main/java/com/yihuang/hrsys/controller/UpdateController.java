package com.yihuang.hrsys.controller;

import com.yihuang.hrsys.entities.Department;
import com.yihuang.hrsys.entities.Employee;
import com.yihuang.hrsys.entities.User;
import com.yihuang.hrsys.service.implement.DepartmentService;
import com.yihuang.hrsys.service.implement.EmployeeService;
import com.yihuang.hrsys.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.yihuang.hrsys.util.DateTransfer.cid2Timestamp;

/**
 * com.yihuang.hrsys.controller
 * 更新接口，更新或添加用户和部门信息
 * @author yihuang728
 * @create 2020/5/15
 */
@Controller
@PropertySource(value = "classpath:application.yml")
public class UpdateController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;

    /***
     * 更新用户
     * @param employee
     * @param session
     * @return
     */
    @RequestMapping(value = "/update")
    public String updateEmployee(@ModelAttribute(value = "Employee") Employee employee, HttpSession session) {
        String s = (String) session.getAttribute("username");
        if (employee == null||s == null) {
            return "redirect:/login";
        }

        //通过员工的身份证号来设置生日
        employee.setBirthday(cid2Timestamp(employee.getcID()));
        employeeService.updateEmployee(employee);
        return "redirect:/index/"+ s;

    }

    /***
     * 添加新员工接口
     * @param employee
     * @param session
     * @return
     */
    @RequestMapping(value = "/add")
    public String addEmployee(@ModelAttribute(value = "newEmployee") Employee employee
                                ,HttpSession session) {
        if (userService.findUser((String) session.getAttribute("username")).isRoot()
                &&employee != null) {
            employee.setDepartmentID((Long)session.getAttribute("nd"));
            employee.setBirthday(cid2Timestamp(employee.getcID()));
            employeeService.insertEmployee(employee);

            User newUser = new User();
            newUser.setUsername(employee.geteID().toString());
            newUser.setPassword(employee.geteID().toString());
            newUser.setRoot(employee.getLevel().charAt(1) >= '7');
            userService.addUser(newUser);
            return "redirect:/dashboard/"+session.getAttribute("nd")+"/"+employee.geteID();
        }
        return "redirect:/dashboard/"+session.getAttribute("nd");
    }

    /***
     * 删除员工接口
     * @param eID
     * @param session
     * @return
     */
    @RequestMapping(value = "/delete/{eID}")
    public String deleteEmployee(@PathVariable Long eID,HttpSession session) {
        if (userService.findUser((String) session.getAttribute("username")).isRoot()) {
            try {
                employeeService.deleteEmployee(eID);
                userService.deleteUser(eID.toString());
            } catch (Exception ignored) {

            }

            return "redirect:/dashboard/"+session.getAttribute("nd");
        }

        return "redirect:/index/"+session.getAttribute("username");
    }

    /***
     * 更新部门接口
     * @param department
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateDepartment")
    public String updateDepartment(@ModelAttribute(value = "Department") Department department, HttpSession session) {
        if (department != null) {
            if (departmentService.getAllDepartmentNames().contains(department.getDepartmentName())) {
                departmentService.updateDepartment(department);
                List<Employee> list = departmentService.getAllEmployee(department.getDepartmentName());

                for (Employee e:list) {
                    e.setDepartmentID(department.getDepartmentID());
                    employeeService.updateEmployee(e);
                }

            } else {
                departmentService.insertDepartment(department);
            }
        }
        return "redirect:/dashboard/"+session.getAttribute("nd");
    }

    /***
     * 添加部门接口
     * @param department
     * @param session
     * @return
     */
    @RequestMapping(value = "/addDepartment")
    public String addDepartment(@ModelAttribute(value = "newDepartment") Department department,HttpSession session) {
        if (department != null) {
            department.setDepartmentID(departmentService.getAllDepartmentNames().size()+1);
            departmentService.insertDepartment(department);
            session.setAttribute("nd",department.getDepartmentID());
        }

        return "redirect:/dashboard/"+session.getAttribute("nd");
    }

    /***
     * 删除部门接口
     * @param departmentID
     * @param session
     * @return
     */
    @RequestMapping(value = "/deleteDepartment/{departmentID}")
    public String deleteDepartment(@PathVariable Long departmentID,HttpSession session) {
        if (userService.findUser((String) session.getAttribute("username")).isRoot()) {
            try {
                Iterable<Employee> employeeIterable = departmentService.getAllEmployee(departmentID);
                for (Employee employee:employeeIterable) {
                    employeeService.deleteEmployee(employee);
                }
                departmentService.deleteDepartment(departmentID);
            } catch (Exception ignored) {

            }
            return "redirect:/dashboard/";
        }
        return "redirect:/index/"+session.getAttribute("username");
    }

    //上传图片
    /***
     * 上传路径
     */
    @Value("${upload.picture.path}")
    private String uploadPicturePath;
    @javax.annotation.Resource
    private ResourceLoader resourceLoader;

    /**
     * @Description //上传
     * @Param [multipartFile]
     * @Author yihaung728
     * @Date 15:10 2018/8/17
     * @Return java.lang.String
     **/
    @RequestMapping("/photo/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile,HttpSession session){

        String username = (String) session.getAttribute("username");
        String fileType = Objects.requireNonNull(multipartFile.getContentType()).substring(6);
        try{
            //String filename = (String) model.getAttribute("username") 对文件重新命名
            //multipartFile.getOriginalFilename() 获取文件原始名称
            //new File(multipartFile.getOriginalFilename()) 根据获取到的原始文件名创建目标文件
            //multipartFile.transferTo() 将收到的文件传输到目标文件中
            multipartFile.transferTo(new File(("img"+username+"."+fileType)));
            Employee employee = employeeService.findEmployee(Long.parseLong(username));
            employee.setPhoto("/photo/"+"img"+username+"."+fileType);
            employeeService.updateEmployee(employee);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return "redirect:/index/"+ username;
    }

    /**
     * @Description //显示
     * @Param [fileName]
     * @Author oneTi
     * @Date 15:11 2018/8/17
     * @Return org.springframework.http.ResponseEntity<org.springframework.core.io.Resource>
     **/
    @RequestMapping("/photo/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> show(@PathVariable String fileName){
        try
        {
            //resourceLoader.getResource("file:" + uploadPicturePath + fileName) 返回指定路径的资源句柄，这里返回的就是URL [file:D:/springboot/upload/test.png]
            //ResponseEntity.ok(T) 返回指定内容主体
            return ResponseEntity.ok(resourceLoader.getResource("file:" + uploadPicturePath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
