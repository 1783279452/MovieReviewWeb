package com.example.moviereviewweb.service;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.Result;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

    Result addMovie(Movie movie);//添加电影
    public Boolean IsMovieById(Integer id);//是否存在电影
    public Result deleteMovie(Integer id);//删除电影
}
