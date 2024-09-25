package com.example.moviereviewweb.service.impl;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.PageBean;
import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.TV;
import com.example.moviereviewweb.mapper.TvMapper;
import com.example.moviereviewweb.service.TvService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TvServiceImpl implements TvService {

    @Autowired
    private TvMapper tvMapper;

    @Override//分页查询电视剧
    public PageBean getPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<TV> list = tvMapper.getPage();
        Page<TV> listpage = (Page<TV>) list;
        PageBean pageBean = new PageBean(listpage.getTotal(), listpage.getResult());
        return pageBean;
    }

    //TODO
    @Override//添加电视剧
    public Result addTv(TV tv) {
        tv.setCreatTime(LocalDateTime.now());
        tvMapper.addTv(tv);

        return null;
    }

    @Override//是否存在电视剧
    public Boolean IsTvById(Integer id) {
        if (tvMapper.getTvById(id) >=1){
            return true;
        }
        return false;
    }

    @Override//删除电视剧，接收电视剧id
    public Result deleteTv(Integer id) {
        int i = tvMapper.deleteById(id);
        if (i > 0 ){
            return Result.success("删除成功，已删除：" + i +"条");
        }
        return Result.error("删除失败");
    }

    @Override//删除除了id外的电视剧
    public Result deleteRuleoutId(Integer id) {
        int num = tvMapper.deleteRuleoutId(id);
        return Result.success("删除了" + num + "条记录");

    }



}
