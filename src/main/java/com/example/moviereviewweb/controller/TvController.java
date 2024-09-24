package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.TV;
import com.example.moviereviewweb.service.TvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TvController {

    @Autowired
    private TvService tvService;

    @PostMapping("/tv/add")//添加电视剧
    public Result add(@RequestBody TV tv){
        tvService.addTv(tv);
        return Result.success();
    }

    @GetMapping("/tv/delete/{id}")//删除电视剧，接收电视剧id
    public Result deteleByid(@PathVariable Integer id){
        return tvService.deleteTv(id);
    }

    @PutMapping("/tv/update")
    public Result updateMovie(@RequestBody TV tv) {
        return tvService.updateTv(tv);
    }

    // 查询电视剧
    @GetMapping("/{id}")
    public Result getTvById(@PathVariable Integer id) {
        TV tv = tvService.getTvById(id);
        if (tv != null) {
            return Result.success(tv);
        }
        return Result.error("电影不存在：" + id);
    }
    @GetMapping
    public Result getAllTv() {
        List<TV> tv = tvService.getAllTv();
        return Result.success(tv);
    }

}
