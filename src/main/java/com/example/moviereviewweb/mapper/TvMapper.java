package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.Bean.TV;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TvMapper {

    @Delete("delete from tv where tid = #{id}")
    int deleteById(Integer id);

    @Insert("insert into tv (tid, name, imgurl, releasetime, type, t_score, language, summary) " +
            "VALUE (#{TID},#{Name},#{imgUrl},#{ReleaseTime},#{type},#{T_score},#{language},#{summary}) ")
    void addTv(TV tv);

    @Select("select count(*) from tv where tid = #{id}")
    int getTvById(Integer id);
}
