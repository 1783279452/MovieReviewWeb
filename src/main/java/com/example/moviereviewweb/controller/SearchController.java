package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.service.TmdbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SearchController {

    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/MultiMovie/{searchdata}")//聚合搜索（电视剧电影等多渠道搜索） 前端发送搜索名字
    public Result test1(@PathVariable String searchdata){

        return Result.success(tmdbService.getMultiSearchResults(searchdata));
    }

}
