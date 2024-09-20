package com.example.moviereviewweb.service.impl;

import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.TV;
import com.example.moviereviewweb.mapper.TvMapper;
import com.example.moviereviewweb.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TvServiceImpl implements TvService {

    @Autowired
    private TvMapper tvMapper;

    //TODO
    @Override//添加电视剧
    public Result addTv(TV tv) {
        tvMapper.addTv(tv);

        return null;
    }

    @Override//删除电视剧，接收电视剧id
    public Result deleteTv(Integer id) {
        int i = tvMapper.deleteById(id);
        if (i > 0 ){
            return Result.success("删除成功，已删除：" + i +"条");
        }
        return Result.error("删除失败");
    }

    @Override
    public Boolean IsTvById(Integer id) {//是否存在电视剧
        int Number = tvMapper.getTvById(id);
        if (Number >= 1){//存在
            return true;
        }
        return false;//不存在
    }

}
