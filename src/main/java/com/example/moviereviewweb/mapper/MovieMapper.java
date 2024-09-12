package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.Bean.Movie;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MovieMapper {

    /*@Insert("INSERT INTO moviereviewweb_database.movie (mid, name, imgurl, releasetime, type, m_score, language, summary) " +
            "VALUE (#{mid},#{name},#{imgUrl},#{releasetime},#{type},#{m_score},#{language},#{summary})")*/
    @Insert("INSERT INTO moviereviewweb_database.movie (mid, name, imgurl, releasetime, type, m_score, language, summary) " +
            "VALUE (#{MID},#{name},#{imgUrl},#{ReleaseTime},#{type},#{M_score},#{language},#{summary})")
    void addMovie(Movie movie);

    @Select("select count(*) from moviereviewweb_database.movie where mid = #{id}")
    int getMovieById(Integer id);
}
