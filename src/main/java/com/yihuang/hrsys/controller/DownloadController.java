package com.yihuang.hrsys.controller;

import com.github.houbb.iexcel.core.writer.IExcelWriter;
import com.github.houbb.iexcel.exception.ExcelRuntimeException;
import com.github.houbb.iexcel.util.excel.ExcelUtil;
import com.yihuang.hrsys.entities.Employee;
import com.yihuang.hrsys.service.implement.DepartmentService;
import com.yihuang.hrsys.service.implement.EmployeeService;
import com.yihuang.hrsys.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * com.yihuang.hrsys.controller
 *
 * @author yihuang728
 * @create 2020/5/25
 */
@Controller
public class DownloadController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "/download/{departmentID}")
    public String downloadExcel(@PathVariable Long departmentID,
                                HttpServletResponse response,
                                HttpSession session) throws UnsupportedEncodingException {

        String departmentName = departmentService.getDepartment(departmentID).getDepartmentName();
        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String filePath = departmentName+sdf.format(new Date()).replace(" ","-") +"职员表"+".xlsx";
        List<Employee> models = departmentService.getAllEmployee(departmentID);

        response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(filePath, "UTF-8"));
        try(IExcelWriter excelWriter = ExcelUtil.get07ExcelWriter(departmentName);
            OutputStream outputStream = response.getOutputStream()) {
            // 可根据实际需要，多次写入列表
            excelWriter.write(models);

            // 将列表内容真正的输出到 excel 文件
            excelWriter.flush(outputStream);
        } catch (IOException e) {
            throw new ExcelRuntimeException(e);
        }


        return "redirect:/dashboard"+session.getAttribute("nd");
    }

}
