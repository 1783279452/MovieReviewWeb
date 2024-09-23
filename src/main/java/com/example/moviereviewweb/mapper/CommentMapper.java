package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.Bean.Comment;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface CommentMapper {

    @Insert("insert into comment (uid, mid, tid, content, score, time) " +
            "VALUE (#{commentUID},#{commentMID},#{commentTID},#{content},#{score},#{time})")
    void addComment(Comment comment);

    @Select("select count(*) from comment where mid = #{mid} and uid = #{uid}")
    int getCommentByMovieId(Integer mid, Integer uid);

    @Delete("delete from comment where eid = #{id}")
    void deletecomment(Integer id);

    //@Update("update moviereviewweb_database.comment set content = #{content} where eid = #{EID}")
    void updateComment(Comment comment);

    @Delete("delete from comment where mid = #{id}")
    int deleteByMovieId(Integer id);

    @Select("select c.eid AS id, c.uid AS user_id , c.mid AS movie_id, c.tid, c.content AS comment, c.score, c.time , u.name AS user_name , m.name AS movie_name " +
            "from comment c " +
            "join movie m on c.mid = m.mid " +
            "join user u on c.uid = u.uid " +
            "where c.eid = #{eid}")
    Map<String, Object> getByEid(Integer eid);



}