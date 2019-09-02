package com.aldar.java.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class JavaTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTaskApplication.class, args);
    }

}
