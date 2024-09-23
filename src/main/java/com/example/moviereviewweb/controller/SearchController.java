package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.service.TmdbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SearchController {

    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/search/{data}")//聚合搜索（电视剧电影等多渠道搜索） 前端发送搜索名字
    public Result test1(@PathVariable String data){

        return Result.success(tmdbService.getMultiSearchResults(data));
    }

    @GetMapping("/search/movie/popular")//获取当前热门电影
    public Result getPopularMovieList(){
        return Result.success(tmdbService.getPopularMovie());
    }

}
