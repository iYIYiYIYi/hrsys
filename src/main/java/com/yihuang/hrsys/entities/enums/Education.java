package com.yihuang.hrsys.entities.enums;

/**
 * com.yihuang.hrsys.entities.enums
 *
 * @author yihuang728
 * @create 2020/5/12
 */
public enum Education {

    /***
     * Education stages
     */
    PrimarySchool(0,"小学"),
    JuniorHigh(1,"初中"),
    SeniorHigh(2,"高中"),
    TechnicalSecondary(3,"中专"),
    College(4,"大专"),
    Bachelor(5,"本科"),
    Master(6,"硕士"),
    Doctor(7,"博士"),
    ;

    public String name;
    public int key;
    Education(int key,String name) {
        this.key = key;this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
