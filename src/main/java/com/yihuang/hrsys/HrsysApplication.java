package com.yihuang.hrsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yihuang728
 */
@MapperScan
@SpringBootApplication
public class HrsysApplication {


    public static void main(String[] args) {
        SpringApplication.run(HrsysApplication.class, args);

    }

}
