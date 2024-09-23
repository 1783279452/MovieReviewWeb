package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.entity.Comment;

import java.util.List;

public interface CommentMapper {
    void insert(Comment comment);

    void updateById(Comment comment);

    void deleteById(Integer id);

    List<Comment> selectAll(Comment comment);



}
