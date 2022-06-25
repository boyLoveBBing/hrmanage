package com.myth.hrmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@MapperScan("com.myth.hrmanage.dao")
public class HrmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmanageApplication.class, args);
    }

}
