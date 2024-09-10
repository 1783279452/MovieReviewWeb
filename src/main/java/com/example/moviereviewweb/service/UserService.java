package com.example.moviereviewweb.service;

import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//用户模块
public interface UserService {
    Result adduser(User user);//添加用户


    List<User> getalluser();//查询全部用户

    Result deleuser(Integer id);//删除用户

    Result getuser(Integer id);//查询用户
}
