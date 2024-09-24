package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.TV;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TvMapper {

    @Delete("delete from tv where tid = #{id}")
    int deleteById(Integer id);

    @Insert("insert into tv (tid, name, imgurl, releasetime, type, t_score, language, summary) " +
            "VALUE (#{TID},#{Name},#{imgUrl},#{ReleaseTime},#{type},#{T_score},#{language},#{summary}) ")
    void addTv(TV tv);

    @Select("select count(*) from tv where tid = #{id}")
    int getTvCountById(Integer id);

    @Select("SELECT * FROM tv")
    List<TV> getAllTv(); // 获取所有电视剧

    @Select("SELECT * FROM tv WHERE mid = #{id}")
    TV getTvById(Integer id); // 根据 ID 查询电视剧
}
