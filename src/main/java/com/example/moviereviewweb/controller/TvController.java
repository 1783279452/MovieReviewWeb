package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.PageBean;
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
@RequestMapping("/tv")
public class TvController {

    @Autowired
    private TvService tvService;

    @GetMapping("/getpage")//分页查询电视剧  前端返回 1.当前页码  2.每页所需数据数
    public Result getMoviePage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        PageBean pageBean = tvService.getPage(page , pageSize);
        return Result.success(pageBean);
    }

    @PostMapping("/add")//添加电视剧
    public Result add(@RequestBody TV tv){
        tvService.addTv(tv);
        return Result.success();
    }

    @GetMapping("/delete/{id}")//删除电视剧，接收电视剧id
    public Result deteleByid(@PathVariable Integer id){
        return tvService.deleteTv(id);
    }
    @GetMapping("/delete/ruleout/{id}")//删除除了id外的电视剧
    public Result deleteRuleoutId(@PathVariable Integer id){
        return tvService.deleteRuleoutId(id);
    }

}
