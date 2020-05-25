package com.yihuang.hrsys.dao;

import com.yihuang.hrsys.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.yihuang.hrsys.dao
 *
 * @author yihuang728
 * @create 2020/4/21
 */
@Repository
public interface EmployeeRepository {

    /***
     * init table
     * @return flag MyBatis
     */
    @Deprecated
    int createTable();

    /***
     * update an employee after finished it's change
     * @param employee the employee object to be updated
     * @return flag of MyBatis
     */
    int updateUserInfo(Employee employee);

    /***
     * insert an employee
     * @param employee insert to database
     * @return flag of MyBatis
     */
    int addEmployee(Employee employee);

    /***
     * SQL method
     * @return a list of all Employee
     */
    List<Employee> findAll();

    /***
     * find an employee by its id
     * @param eid to find the employee
     * @return Employee
     */
    Employee findByEID(long eid);

    /***
     * find an employee by its cid (civil identity)
     * @param cid to find the employee
     * @return employee
     */
    Employee findByCID(String cid);

    /***
     * find employees by a name
     * @param name employee's name
     * @return a list of employees
     */
    List<Employee> findByName(String name);

    /***
     * find employee by work ID
     * @param wID
     * @return Employee
     */
    Employee findByWID(long wID);

    /***
     * delete an employee
     * @param employee employee object
     * @return MyBatis flag
     */
    int remove(Employee employee);

    /***
     * delete an employee
     * @param eID employee eID
     * @return MyBatis flag
     */
    int remove(Long eID);

}
