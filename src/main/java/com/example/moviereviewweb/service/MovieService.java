package com.example.moviereviewweb.service;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//电视剧模块
public interface MovieService {

    Result addMovie(Movie movie);//添加电影
    public Boolean IsMovieById(Integer id);//是否存在电影
    public Result deleteMovie(Integer id);//删除电影

    public Result updateMovie(Movie movie); // 更新电影
    Movie getMovieById(Integer id); // 查询单个电影
    List<Movie> getAllMovies(); // 获取所有电影
}
