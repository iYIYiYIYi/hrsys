package com.yihuang.hrsys.entities;

import java.util.List;

public class Department {

    private Long departmentID;
    private String departmentName;
    private List<Employee> employees;
    private Long departmentFunctionID;
    private Long superiorDepartment;

    public Department() {
    }

    public Department(long departmentID, String departmentName, List<Employee> employees, long departmentFunctionID, Long superiorDepartment) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.employees = employees;
        this.departmentFunctionID = departmentFunctionID;
        this.superiorDepartment = superiorDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                ", departmentFunctionID=" + departmentFunctionID +
                ", superiorDepartment=" + superiorDepartment +
                '}';
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(long departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getDepartmentFunctionID() {
        return departmentFunctionID;
    }

    public void setDepartmentFunctionID(long departmentFunctionID) {
        this.departmentFunctionID = departmentFunctionID;
    }

    public Long getSuperioDepartment() {
        return superiorDepartment;
    }

    public void setSuperioDepartment(Long superiorDepartment) {
        this.superiorDepartment = superiorDepartment;
    }
}
