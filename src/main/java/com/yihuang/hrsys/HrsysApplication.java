package com.yihuang.hrsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring Boot启动类
 * @author yihuang728
 */
@MapperScan
@SpringBootApplication
@EnableScheduling
public class HrsysApplication {


    public static void main(String[] args) {
        SpringApplication.run(HrsysApplication.class, args);

    }

}
