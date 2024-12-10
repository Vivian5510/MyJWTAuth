package com.rosy.myjwtauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyJwtAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyJwtAuthApplication.class, args);
    }

}
