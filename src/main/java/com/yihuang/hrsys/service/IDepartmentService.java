package com.yihuang.hrsys.service;

import com.yihuang.hrsys.entities.Department;
import com.yihuang.hrsys.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.yihuang.hrsys.service
 *
 * @author yihuang728
 * @create 2020/04/27
 */
public interface IDepartmentService {

    public void insertDepartment(Department department);

    public void deleteDepartment(Department department);

    public void deleteDepartment(String departmentName);

    public void deleteDepartment(Long departmentID);

    public void updateDepartment(Department department);

    public Department getDepartment(String departmentName);

    public Department getDepartment(Long departmentID);

    public List<Department> getAllDepartment();

    public List<Employee> getAllEmployee(long departmentID);

    public List<Employee> getAllEmployee(String departmentName);

    public List<String> getAllDepartmentNames();

}
