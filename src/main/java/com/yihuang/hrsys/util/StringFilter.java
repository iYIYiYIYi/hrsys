package com.yihuang.hrsys.util;

/**
 * com.yihuang.hrsys.util
 *
 * @author yihuang728
 * @create 2020/4/24
 */
public class StringFilter {

    /***
     * Determines a String and returns true only if it is a Phone number
     * @param s
     * @return boolean
     */
    public static Boolean judgePhone(String s) {
        if (s.length() != 11) {
            return false;
        }

        return true;
    }

    /***
     * Determines a String and returns true only if it is a Email address
     * @param s
     * @return boolean
     */
    public static Boolean judgeEmail(String s) {
        if (!(s.contains("@") && s.contains(".com"))) {
            return false;
        }

        return true;
    }
}
