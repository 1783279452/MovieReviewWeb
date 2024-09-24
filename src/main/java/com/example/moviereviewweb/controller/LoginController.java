package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.User;
import com.example.moviereviewweb.service.UserService;
import com.example.moviereviewweb.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")//注册用户
    public Result signUp(@RequestBody User user){
        return userService.adduser(user);
    }

    @PostMapping("login")//登录及权限校验功能
    public Result login(@RequestBody User user){
//        对前端传来的密码进行md5加密 再查询
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());//spring提供的工具类DigestUtils
        user.setPassword(password);
        return  userService.login(user);

    }
    @GetMapping("/")
    public Result hello() {return Result.success();

    }
}
