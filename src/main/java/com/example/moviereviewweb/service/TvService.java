package com.example.moviereviewweb.service;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.PageBean;
import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.TV;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//电视剧模块
public interface TvService {

    Result addTv(TV tv);//添加电视剧

    Boolean IsTvById(Integer id);//是否存在电视剧

    Result deleteTv(Integer id);//删除电视剧，接收电视剧id
    Result deleteRuleoutId(Integer id);//删除除了id之外的电影

    PageBean getPage(Integer page, Integer pageSize);//分页查询电视剧
}
