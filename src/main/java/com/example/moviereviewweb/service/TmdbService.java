package com.example.moviereviewweb.service;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//tmdb http请求处理模块
public interface TmdbService {

    public List<Movie> getMultiMovie(String data);//聚合搜索
    //public Result getmovie();

}
