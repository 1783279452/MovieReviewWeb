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

    @Insert("insert into tv (tid, name, imgurl, releasetime, type, t_score, language, summary ,creattime) " +
            "VALUE (#{TID},#{Name},#{imgUrl},#{ReleaseTime},#{type},#{T_score},#{language},#{summary},#{CreatTime}) ")
    void addTv(TV tv);

    @Select("select count(*) from tv where tid = #{id}")
    int getTvById(Integer id);

    @Delete("delete from tv where tid != #{id}")
    int deleteRuleoutId(Integer id);

    @Select("select tid, name, imgurl, releasetime, type, t_score, language, summary, creattime from tv")
    List<TV> getPage();
}
