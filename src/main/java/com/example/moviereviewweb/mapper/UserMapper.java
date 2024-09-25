package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.Bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user (uid, username, password, name, avatarurl, phonenumber, gender, create_time, statu) " +
            "VALUE (#{UID},#{username},#{password},#{name},#{avatarUrl},#{phoneNumber},#{gender},#{createTime},#{statu})")
    void adduser(User user);

    @Insert("insert into admin (uid, username, password, name, avatarurl, phonenumber, gender, create_time, statu) " +
            "VALUE (#{UID},#{username},#{password},#{name},#{avatarUrl},#{phoneNumber},#{gender},#{createTime},#{statu})")
    void addadmin(User user);

    @Select("select uid, username, password, name, avatarurl, phonenumber, gender, create_time, statu,create_Time from user ")
    List<User> getalluser();

    @Delete("delete from user where uid = #{id}")
    void deleuser(Integer id);


    @Select("select count(*) from user where username = #{username}")
    int isUsername(String username);


    @Select("select uid, username, password, name, avatarurl, phonenumber, gender, create_time createTime, statu from user where uid = #{id}")
    User getuser(Integer id);

    @Select("select count(*) from user where uid = #{id}")
    int isUid(Integer id);

    @Select("select statu,uid , username , password from user where username =#{username} and password = #{password}")
    User loginUser(User user);

    @Select("select statu,uid , username , password from admin where username =#{username} and password = #{password}")
    User loginAdmin(User user);

    @Select("select count(*) from admin where username = #{username}")
    int isAdminName(String username);
}
