package com.yihuang.hrsys;

import com.yihuang.hrsys.entities.Department;
import com.yihuang.hrsys.dao.DepartmentRepository;
import com.yihuang.hrsys.dao.EmployeeRepository;
import com.yihuang.hrsys.dao.UserRepository;
import com.yihuang.hrsys.entities.Employee;
import com.yihuang.hrsys.entities.User;
import com.yihuang.hrsys.entities.enums.EmployeeState;
import com.yihuang.hrsys.service.implement.EmployeeService;
import com.yihuang.hrsys.service.implement.UserService;
import com.yihuang.hrsys.util.DateTransfer;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.yihuang.hrsys.util.DateTransfer.cid2Timestamp;
import static com.yihuang.hrsys.util.PasswordEncoder.convertMD5;
import static com.yihuang.hrsys.util.PasswordEncoder.string2MD5;

@MapperScan
@SpringBootTest
class HrsysApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
        User user = userService.findUser("01");
//        password = string2MD5(password);
//        password = string2MD5(password + username);
        user.setPassword(string2MD5(string2MD5("admin")+"01"));
        userService.updateUser(user);
    }

}
