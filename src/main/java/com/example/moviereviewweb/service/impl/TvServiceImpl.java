package com.example.moviereviewweb.service.impl;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.TV;
import com.example.moviereviewweb.mapper.TvMapper;
import com.example.moviereviewweb.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



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
    public Boolean IsTvById(Integer id) { // 是否存在电视剧
        TV tv = tvMapper.getTvById(id); // 返回的是TV对象，而不是int
        return tv != null;  // 如果tv不为null，则说明存在此电视剧，返回true；否则返回false
    }
    public Result updateTv(TV tv) {
        if (IsTvById(tv.getTID())) {
            // 更新电影逻辑，例如调用 mapper.updateMovie(movie);
            return Result.success();
        }
        return Result.error("更新失败，不存在此电视剧：" + tv.getTID());
    }

    public TV getTvById(Integer id) {
        return tvMapper.getTvById(id);
    }

    public List<TV> getAllTv() {
        return tvMapper.getAllTv();
    }

}
