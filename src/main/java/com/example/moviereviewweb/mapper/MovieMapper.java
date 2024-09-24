package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.Bean.Movie;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper {

    /*@Insert("INSERT INTO moviereviewweb_database.movie (mid, name, imgurl, releasetime, type, m_score, language, summary) " +
            "VALUE (#{mid},#{name},#{imgUrl},#{releasetime},#{type},#{m_score},#{language},#{summary})")*/
    @Insert("INSERT INTO movie (mid, name, imgurl, releasetime, type, m_score, language, summary) " +
            "VALUE (#{MID},#{Name},#{imgUrl},#{ReleaseTime},#{type},#{M_score},#{language},#{summary})")
    void addMovie(Movie movie);

    @Select("select count(*) from movie where mid = #{id}")
    int getMovieCountById(Integer id);

    @Select("SELECT * FROM movie")
    List<Movie> getAllMovies(); // 获取所有电影
    @Select("SELECT * FROM movie WHERE mid = #{id}")
    Movie getMovieById(Integer id); // 根据 ID 查询电影


    @Delete("delete from movie where mid = #{id}")
    void deletemovie(Integer id);
}
