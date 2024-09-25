package com.example.moviereviewweb;

import com.example.moviereviewweb.Bean.Genre;
import com.example.moviereviewweb.Bean.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieReviewWebApplicationTests {

    @Test
    void contextLoads() {
    }


    public static void main(String[] args) {
        System.out.println(Result.success(Genre.getCategoryNameById(2)));
    }

}

