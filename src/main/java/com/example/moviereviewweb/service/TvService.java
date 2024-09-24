package com.example.moviereviewweb.service;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.TV;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//电视剧模块
public interface TvService {

    Result addTv(TV tv);//添加电视剧

    Boolean IsTvById(Integer id);//是否存在电视剧

    Result deleteTv(Integer id);//删除电视剧，接收电视剧id

    public Result updateTv(TV tv); // 更新电视剧

    TV getTvById(Integer id); // 查询单个电视剧

    List<TV>getAllTv(); // 获取所有电影
}
