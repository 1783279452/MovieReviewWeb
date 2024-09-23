package com.example.moviereviewweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.moviereviewweb.mapper")

public class MovieReviewWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieReviewWebApplication.class, args);
    }

}
