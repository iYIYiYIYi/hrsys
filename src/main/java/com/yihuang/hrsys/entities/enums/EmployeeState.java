package com.yihuang.hrsys.entities.enums;

/**
 * com.yihuang.hrsys.entities.enums
 *
 * @author yihuang728
 * @create 2020/5/12
 */
public enum EmployeeState {

    /***
     * Employee States
     */
    InServiceStaff(0,"在职"),
    PartTimeStaff(1,"兼职"),
    TrialStaff(2,"试用"),
    SeparatedStaff(3,"离职"),
    ReEmploymentStaff(4,"返聘"),
    RetiredStaff(5,"退休"),
    ;
    public int key;
    public String name;

    EmployeeState(int key,String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
