package com.example.moviereviewweb.service.impl;

import com.example.moviereviewweb.Bean.Comment;
import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.mapper.CommentMapper;
import com.example.moviereviewweb.service.CommentService;
import com.example.moviereviewweb.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;



    @Override//添加评价
    public Result addComment(Comment comment) {
        if (isCommentByMovieId(comment.getCommentMID() , comment.getCommentUID()) == false){
            comment.setTime(LocalDateTime.now());
            commentMapper.addComment(comment);
            return Result.success();
        }
        return Result.error("失败，评价重复");

    }

    @Override//删除评价 接收评价id
    public Result deletecomment(Integer id) {
        commentMapper.deletecomment(id);
        return Result.success();
    }

    @Override//更新评价  --接收评价对象
    public Result updateComment(Comment comment) {
        commentMapper.updateComment(comment);
        return Result.success();
    }

    @Override//删除评价，接收电影id
    public Result deleteByMovieId(Integer id) {
        int i = commentMapper.deleteByMovieId(id);
        if (i > 0){
            return Result.success("删除成功，已删除:" + i +"条");
        }
        return Result.error("删除失败");
    }

    //是否存在相同电影的评价 -- 接收电影id
    public boolean isCommentByMovieId(Integer mid , Integer uid){
        int number = commentMapper.getCommentByMovieId(mid , uid);
        if (number >= 1){
            return true;
        }
        return false;
    }

}
