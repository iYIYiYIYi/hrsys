package com.yihuang.hrsys.configuration;

import com.yihuang.hrsys.service.implement.DatabaseBackup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * com.yihuang.hrsys.configuration
 * 数据库备份定时任务
 * @author yihuang728
 * @create 2020/5/25
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");

    @Autowired
    private DatabaseBackup databasebackup;

    /**
     * 每天定时执行数据库备份
     */
    @Scheduled(cron = "30 30 18 * * ?")
    public void reportCurrentTime() {
        String format = dateFormat.format(System.currentTimeMillis());
        log.info("The time is now {}", format);
        databasebackup.exportSql(format);
    }

}
