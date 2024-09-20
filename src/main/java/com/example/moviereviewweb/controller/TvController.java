package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.TV;
import com.example.moviereviewweb.service.TvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}
