package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.User;
import com.example.moviereviewweb.MovieReviewWebApplication;
import com.example.moviereviewweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")//添加用户
    public Result adduser(@RequestBody User user){

        log.info("控制层-添加用户-user：" + user);
        return userService.adduser(user);
    }

    @GetMapping("/user")//查询全部用户
    public Result getalluser(){
        List<User> list = userService.getalluser();
        return Result.success(list);
    }

    @GetMapping("/user/{id}")//查询用户-前端发送用户id
    public Result getuser(@PathVariable Integer id){
        return userService.getuser(id);
    }


    @DeleteMapping("/user/{id}")//删除用户-前端发送用户id
    public Result deleuser(@PathVariable Integer id){
        return userService.deleuser(id);
    }

    //TODO
    @GetMapping("/userpage")//分页查询
    public Result getpage(){
        return Result.success();
    }

    @GetMapping("/userquerypage")//条件查询--(可分页返回)
    public Result getquerypage(){
        return Result.success();
    }

    @PostMapping("/updateuser")//用户信息更新-动态sql修改
    public Result updauser(@RequestBody User user){
        return Result.success();
    }



}
