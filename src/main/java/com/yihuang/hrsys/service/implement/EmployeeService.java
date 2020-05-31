package com.yihuang.hrsys.service.implement;

import com.yihuang.hrsys.dao.EmployeeRepository;
import com.yihuang.hrsys.entities.Employee;
import com.yihuang.hrsys.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.yihuang.hrsys.service.implement
 * 员工服务，提供员工的数据获取和修改功能
 * @author yihuang728
 * @create 2020/5/13
 */
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void insertEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateUserInfo(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.remove(employee);
    }

    @Override
    public void deleteEmployee(Long eID) {
        employeeRepository.remove(eID);
    }

    @Override
    public Employee findEmployee(long eid) {
        return employeeRepository.findByEID(eid);
    }

    @Override
    public Employee findByWID(long wID) {
        return employeeRepository.findByWID(wID);
    }

    @Override
    public Employee findByCID(String cID) {
        return employeeRepository.findByCID(cID);
    }

    @Override
    public List<Employee> findEmployee(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
