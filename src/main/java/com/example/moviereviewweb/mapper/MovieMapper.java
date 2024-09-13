package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.Bean.Movie;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MovieMapper {

    /*@Insert("INSERT INTO moviereviewweb_database.movie (mid, name, imgurl, releasetime, type, m_score, language, summary) " +
            "VALUE (#{mid},#{name},#{imgUrl},#{releasetime},#{type},#{m_score},#{language},#{summary})")*/
    @Insert("INSERT INTO movie (mid, name, imgurl, releasetime, type, m_score, language, summary) " +
            "VALUE (#{MID},#{Name},#{imgUrl},#{ReleaseTime},#{type},#{M_score},#{language},#{summary})")
    void addMovie(Movie movie);

    @Select("select count(*) from movie where mid = #{id}")
    int getMovieById(Integer id);

    @Delete("delete from movie where mid = #{id}")
    void deletemovie(Integer id);
}
