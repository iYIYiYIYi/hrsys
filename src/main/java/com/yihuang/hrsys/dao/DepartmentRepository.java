package com.yihuang.hrsys.dao;

import com.yihuang.hrsys.entities.Department;
import com.yihuang.hrsys.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.yihuang.hrsys.dao
 *
 * @author yihuang728
 * @create 2020/04/27
 */
@Repository
public interface DepartmentRepository {

    /***
     * create table
     * do not use if not necessary
     * @return status of MyBatis
     */
    @Deprecated
    int createTable();

    /***
     * delete department by an department Object
     * @param department entity
     * @return status of MyBatis
     */
    int remove(Department department);

    /***
     * delete department by an department Object
     * @param departmentID entity ID
     * @return status of MyBatis
     */
    int remove(Long departmentID);

    /***
     * Department name should be unique
     * remove department by its name
     * @param departmentName String
     * @return status of Mybatis
     */
    int removeByDepartmentName(String departmentName);

    /***
     * add new department
     * @param department entity
     * @return status of MyBatis
     */
    int addDepartment(Department department);

    /***
     * get department by name
     * @param departmentName String
     * @return department object
     */
    Department getDepartment(String departmentName);

    /****
     * get department by ID
     * @param departmentID ID
     * @return department
     */
    Department getDepartmentByID(Long departmentID);

    /***
     * get all departments
     * @return a list of department entity
     */
    List<Department> getAllDepartment();

    /***
     * get all department names
     * @return list of String
     */
    List<String> getAllDepartmentName();

    /***
     * get all employees of a department
     * @param departmentID the department ID
     * @return list of employees
     */
    List<Employee> getEmployees(long departmentID);

    /***
     * refresh department information
     * @param department the information
     * @return status of MyBatis
     */
    int updateDepartmentInfo(Department department);

}
