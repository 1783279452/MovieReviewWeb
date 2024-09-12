package com.example.moviereviewweb.service;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.TV;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//tmdb http请求处理模块
public interface TmdbService {

    //public List<Movie> getMultiMovie(String data);//聚合搜索  原始版本备份（封装为电影对象）

    public List<Object> getMultiSearchResults(String data);//聚合搜索，分类识别电影、电视剧

}
