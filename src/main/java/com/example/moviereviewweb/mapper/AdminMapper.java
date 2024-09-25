package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作admin相关数据接口
*/
public interface AdminMapper {

    /**
      * 新增
    */
    int insert(Admin admin);

    /**
      * 删除
    */
    @Delete("delete from admin where uid = #{uid}")
    int deleteById(Integer uid);

    /**
      * 修改
    */
    int updateById(Admin admin);

    /**
      * 根据ID查询
    */
    @Select("select * from admin where uid = #{uid}")
    Admin selectById(Integer uid);

    /**
      * 查询所有
    */
    List<Admin> selectAll(Admin admin);

    @Select("select * from admin where username = #{username}")
    Admin selectByUsername(String username);

}