package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.mapper.MovieMapper;
import com.example.moviereviewweb.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/delete/{id}")//删除电影————接收电影id
    public Result deleteMovie(@PathVariable Integer id) {
        return movieService.deleteMovie(id);
    }

    @GetMapping("/delete/ruleout/{id}")//删除除了id外的电影
    public Result deleteRuleoutId(@PathVariable Integer id){
        return movieService.deleteRuleoutId(id);
    }
    @PostMapping("/add")//
    public Result addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }
    @PutMapping("/update")
    public Result updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    // 查询电影
    @GetMapping("/get/{id}")
    public Result getMovieById(@PathVariable Integer id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return Result.success(movie);
        }
        return Result.error("电影不存在：" + id);
    }
    @GetMapping
    public Result getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return Result.success(movies);
    }
}
