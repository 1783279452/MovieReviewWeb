package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.Bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into moviereviewweb_database.user (uid, username, password, name, avatarurl, phonenumber, gender, create_time) " +
            "VALUE (#{UID},#{username},#{password},#{name},#{avatarUrl},#{phoneNumber},#{gender},#{createTime})")
    void adduser(User user);

    @Select("select uid, username, password, name, avatarurl, phonenumber, gender, create_time createTime from moviereviewweb_database.user ")
    List<User> getalluser();

    @Delete("delete from moviereviewweb_database.user where uid = #{id}")
    void deleuser(Integer id);


    @Select("select count(*) from moviereviewweb_database.user where username = #{username}")
    int isUsername(String username);


    @Select("select uid, username, password, name, avatarurl, phonenumber, gender, create_time createTime from moviereviewweb_database.user where uid = #{id}")
    User getuser(Integer id);

    @Select("select count(*) from moviereviewweb_database.user where uid = #{id}")
    int isUid(Integer id);
}
