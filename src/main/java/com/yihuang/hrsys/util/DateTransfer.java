package com.yihuang.hrsys.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * com.yihuang.hrsys.util
 * 日期转换，由于Java的Date日期对象存入MySQL时可能会发生无法读取的现象
 * 故将Date对象转换为MySQL能识别的Timestamp对象
 * 并将Timestamp对象存入数据库
 * @author yihuang728
 * @create 2020/4/24
 */
public class DateTransfer {

    /***
     * 将Java date转化为 数据库Date
     * @param d java.util.Date
     * @return Timestamp
     */
    public static Timestamp dateToTimestamp(Date d) {
        if (null == d) {
            return null;
        }
        return new java.sql.Timestamp(d.getTime());
    }

    /***
     * 将数据库Date 转化为java date
     * @param t Timestamp
     * @return jav.util.Date
     */
    public static Date timestampToDate(Timestamp t) {
        if (null == t) {
            return null;
        }
        return new Date(t.getTime());
    }

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /***
     * format Timestamp
     * @param t Timestamp to be formatted
     * @return formatted Timestamp
     */
    public static Timestamp formatTimestamp(Timestamp t) {
        return Timestamp.valueOf(dateFormat.format(t));
    }

    /***
     * 截取Timestamp对象中的无用信息并返回String字符串对象
     * @param timestamp
     * @return
     */
    public static String timestampToString(Timestamp timestamp) {
        return timestamp==null?"":timestamp.toString().substring(0,10);
    }

    /***
     * 提取身份证中的日期字符并将其转换为Timestamp对象
     * @param cid
     * @return
     */
    public static Timestamp cid2Timestamp(String cid) {

        StringBuilder date = new StringBuilder(cid.substring(6,14));
        date.insert(4,'-');
        date.insert(7,'-');
        date.append(" 00:00:00");
        return Timestamp.valueOf(String.valueOf(date));
    }

}
