package com.yihuang.hrsys.service.implement;

import com.yihuang.hrsys.dao.DepartmentRepository;
import com.yihuang.hrsys.entities.Department;
import com.yihuang.hrsys.entities.Employee;
import com.yihuang.hrsys.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.yihuang.hrsys.service.implement
 * 部门服务，提供部门各类数据的修改和获取功能
 * @author yihuang728
 * @create 2020/5/13
 */

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void insertDepartment(Department department) {
        departmentRepository.addDepartment(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentRepository.remove(department);
    }

    @Override
    public void deleteDepartment(String departmentName) {
        departmentRepository.removeByDepartmentName(departmentName);
    }

    @Override
    public void deleteDepartment(Long departmentID) {
        departmentRepository.remove(departmentID);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentRepository.updateDepartmentInfo(department);
    }

    @Override
    public Department getDepartment(String departmentName) {
        return departmentRepository.getDepartment(departmentName);
    }

    @Override
    public Department getDepartment(Long departmentID) {
        return departmentRepository.getDepartmentByID(departmentID);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.getAllDepartment();
    }

    @Override
    public List<Employee> getAllEmployee(long departmentID) {
        return departmentRepository.getEmployees(departmentID);
    }

    @Override
    public List<Employee> getAllEmployee(String departmentName) {
        long departmentID = departmentRepository.getDepartment(departmentName).getDepartmentID();
        return departmentRepository.getEmployees(departmentID);
    }

    @Override
    public List<String> getAllDepartmentNames() {
        return departmentRepository.getAllDepartmentName();
    }
}
