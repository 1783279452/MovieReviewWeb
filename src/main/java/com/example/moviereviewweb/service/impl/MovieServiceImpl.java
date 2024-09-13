package com.example.moviereviewweb.service.impl;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.mapper.MovieMapper;
import com.example.moviereviewweb.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    //添加电影数据 前端提供movie对象相应的数据。
    public Result addMovie(Movie movie){
        log.info("传入数据" + movie);
        movieMapper.addMovie(movie);
        return Result.success();
    }

    //删除电影————接受电影id
    public Result deleteMovie(Integer id){
        if (IsMovieById(id) == true){
            movieMapper.deletemovie(id);
            return Result.success();
        }
        return Result.error("删除失败，不存在此电影：" + id);

    }

    //查询是否存在电影——发送电影id
    public Boolean IsMovieById(Integer id){
        int Number = movieMapper.getMovieById(id);
        if (Number >= 1){//存在
            return true;
        }
        return false;//不存在
    }



}
