package com.yihuang.hrsys.entities;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.yihuang.hrsys.entities.enums.Education;
import com.yihuang.hrsys.entities.enums.EmployeeState;
import com.yihuang.hrsys.entities.enums.PoliticState;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author yihaung728
 * @date 2020/4/20
 * com.yihuang.hrsys.entities class
 */
public class Employee {

    /***
     * below are civil information
     */
    @ExcelField(headName = "员工编号")
    private Long eID;

    @ExcelField(headName = "员工姓名")
    private String name;
    @ExcelField(headName = "性别（男为1，女为0）")
    private String gender;

    /***
     *photo storage location
     */
    private String photo;
    @ExcelField(headName = "民族")
    private String nation;
    @ExcelField(headName = "出生日期")
    private Timestamp birthday;
    @ExcelField(headName = "政治面貌")
    private PoliticState politics_status;
    @ExcelField(headName = "文化程度")
    private Education education;
    @ExcelField(headName = "是否结婚")
    private Boolean marriage;
    @ExcelField(headName = "籍贯")
    private String hometown;
    @ExcelField(headName = "身份证号")
    private String cID;
    @ExcelField(headName = "手机号码",writeRequire = false)
    private Long phone;
    private String fileLoc;
    private String householdRegistrationLoc;

    /***
     * below are work information
     */
    private Long wID;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Timestamp employmentDate;
    private String job;
    private String level;
    private Long seID;
    private EmployeeState employeeState;
    @ExcelField(headName = "部门编号")
    private Long departmentID;

    public Employee() {
    }

    public Employee(Long eID, String name, String gender, String photo, String nation, Timestamp birthday, PoliticState politics_status, Education education, Boolean marriage, String hometown, String cID, Long phone, String fileLoc, String householdRegistrationLoc, Long wID, Timestamp employmentDate, String job, String level, Long seID, EmployeeState employeeState, Long departmentID) {
        this.eID = eID;
        this.name = name;
        this.gender = gender;
        this.photo = photo;
        this.nation = nation;
        this.birthday = birthday;
        this.politics_status = politics_status;
        this.education = education;
        this.marriage = marriage;
        this.hometown = hometown;
        this.cID = cID;
        this.phone = phone;
        this.fileLoc = fileLoc;
        this.householdRegistrationLoc = householdRegistrationLoc;
        this.wID = wID;
        this.employmentDate = employmentDate;
        this.job = job;
        this.level = level;
        this.seID = seID;
        this.employeeState = employeeState;
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eID=" + eID +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", photo='" + photo + '\'' +
                ", nation='" + nation + '\'' +
                ", birthday=" + birthday +
                ", politics_status=" + politics_status +
                ", education=" + education +
                ", marriage=" + marriage +
                ", hometown='" + hometown + '\'' +
                ", cID=" + cID +
                ", phone=" + phone +
                ", fileLoc='" + fileLoc + '\'' +
                ", householdRegistrationLoc='" + householdRegistrationLoc + '\'' +
                ", wID=" + wID +
                ", employmentDate=" + employmentDate +
                ", job='" + job + '\'' +
                ", level='" + level + '\'' +
                ", seID=" + seID +
                ", employeeState=" + employeeState +
                ", departmentID=" + departmentID +
                '}';
    }

    public Long geteID() {
        return eID;
    }

    public void seteID(Long eID) {
        this.eID = eID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenderS() {
        if (gender.equals("1")) {
            return "男";
        } else {
            return "女";
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public PoliticState getPolitics_status() {
        return politics_status;
    }

    public void setPolitics_status(PoliticState politics_status) {
        this.politics_status = politics_status;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getMarriageS() {
        if (marriage) {
            return "已婚";
        }
        return "未婚";
    }

    public Boolean getMarriage() {
        return marriage;
    }

    public void setMarriage(Boolean marriage) {
        this.marriage = marriage;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getFileLoc() {
        return fileLoc;
    }

    public void setFileLoc(String fileLoc) {
        this.fileLoc = fileLoc;
    }

    public String getHouseholdRegistrationLoc() {
        return householdRegistrationLoc;
    }

    public void setHouseholdRegistrationLoc(String householdRegistrationLoc) {
        this.householdRegistrationLoc = householdRegistrationLoc;
    }

    public Long getwID() {
        return wID;
    }

    public void setwID(Long wID) {
        this.wID = wID;
    }

    public Timestamp getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Timestamp employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getSeID() {
        return seID;
    }

    public void setSeID(Long seID) {
        this.seID = seID;
    }

    public EmployeeState getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(EmployeeState employeeState) {
        this.employeeState = employeeState;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }

    public String getBirthdayS() {
        return birthday==null?"":this.birthday.toString().substring(0,10);
    }

    public String getEmploymentDateS() {
        return employmentDate==null?"":this.employmentDate.toString().substring(0,10);
    }
}
