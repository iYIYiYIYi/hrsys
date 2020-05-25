package com.yihuang.hrsys.service;

import com.yihuang.hrsys.entities.Employee;

import java.util.List;

/**
 * com.yihuang.hrsys.service
 *
 * @author yihuang728
 * @create 2020/5/13
 */
public interface IEmployeeService {

    public void insertEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public void deleteEmployee(Long eID);

    public Employee findEmployee(long eid);

    public Employee findByWID(long wID);

    public Employee findByCID(String cID);

    public List<Employee> findEmployee(String name);

    public List<Employee> findAll();

}
