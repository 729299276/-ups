package com.online.edu.eduservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@MapperScan("com.online.edu.eduservice.mapper")
public class EduApp {
    public static void main(String[] args) {
    		SpringApplication.run(EduApp.class, args);
    	}
}
