package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.mapper.MovieMapper;
import com.example.moviereviewweb.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movie/delete/{id}")//删除电影————接收电影id
    public Result deleteMovie(@PathVariable Integer id) {

        return movieService.deleteMovie(id);
    }

}
