package com.example.moviereviewweb.service;

import com.example.moviereviewweb.Bean.Comment;
import com.example.moviereviewweb.Bean.Result;
import org.springframework.stereotype.Service;

@Service//评价模块
public interface CommentService {
    Result addComment(Comment comment);//添加评价 --接收post数据

    Result deletecomment(Integer id);//删除评价 --接收评价id

    Result updateComment(Comment comment);//更新评价  --接收评价对象

    Result deleteByMovieId(Integer id);

    Result get(Integer eid);
}
