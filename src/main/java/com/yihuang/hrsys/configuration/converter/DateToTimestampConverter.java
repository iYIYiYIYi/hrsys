package com.yihuang.hrsys.configuration.converter;

import com.yihuang.hrsys.util.DateTransfer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * com.yihuang.hrsys.configuration.converter
 *
 * @author yihuang728
 * @create 2020/05/20
 */
@Component
public class DateToTimestampConverter implements Converter<Date, Timestamp> {

    @Override
    public Timestamp convert(Date date) {
        return DateTransfer.dateToTimestamp(date);
    }
}
