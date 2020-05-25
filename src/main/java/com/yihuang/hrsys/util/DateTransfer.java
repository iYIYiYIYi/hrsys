package com.yihuang.hrsys.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * com.yihuang.hrsys.util
 *
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

    public static String timestampToString(Timestamp timestamp) {
        return timestamp==null?"":timestamp.toString().substring(0,10);
    }

    public static Timestamp cid2Timestamp(String cid) {

        StringBuilder date = new StringBuilder(cid.substring(6,14));
        date.insert(4,'-');
        date.insert(7,'-');
        date.append(" 00:00:00");
        return Timestamp.valueOf(String.valueOf(date));
    }

}
