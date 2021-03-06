package com.yihuang.hrsys;

import com.yihuang.hrsys.service.implement.DepartmentService;
import com.yihuang.hrsys.service.implement.EmployeeService;
import com.yihuang.hrsys.service.implement.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@MapperScan
@SpringBootTest
class HrsysApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;


    @Test
    void contextLoads() {

    }

}
