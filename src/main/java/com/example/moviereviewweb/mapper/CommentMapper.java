package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.Bean.Comment;
import org.apache.ibatis.annotations.*;

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
}
