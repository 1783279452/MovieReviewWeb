package com.example.moviereviewweb.service.impl;

import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.User;
import com.example.moviereviewweb.mapper.UserMapper;
import com.example.moviereviewweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result adduser(User user) {//添加用户
        if (isUsername(user.getUsername())){
            return Result.error("失败，添加的用户名重复");
        }
        if (isPassword(user.getPassword())){
            return Result.error("失败，密码长度需要大于等于6位");
        }
        if (isPasswordNull(user.getPassword())){
            return Result.error("失败，密码不能为空");
        }
        if (isUsernameNull(user.getUsername())){
            return Result.error("失败，账号不能为空");
        }
        user.setCreateTime(LocalDateTime.now());
        userMapper.adduser(user);
        return Result.success("成功");
    }

    @Override
    public List<User> getalluser() {//查询全部用户
        List<User> list = userMapper.getalluser();
        return list;
    }

    @Override
    public Result deleuser(Integer id) {//删除用户-通过id
        if (isUid(id) == false){
            return Result.error("失败，不存在id为：" + id +" 的用户");
        }
        userMapper.deleuser(id);
        return Result.success();
    }

    @Override
    public Result getuser(Integer id) {//查询用户-通过用户id
        if (userMapper.getuser(id) == null){
            return Result.error("失败，查无此用户");
        }
        User user = userMapper.getuser(id);
        return Result.success(user);
    }

    /*以下为异常逻辑处理*/
    public boolean isUid(Integer id){//判断是否存在uid
        if (userMapper.isUid(id) >= 1){
            return true;
        }
        return false;
    }
    public boolean isUsername(String username){//判断是否存在账号
        if (userMapper.isUsername(username) >=1 ){
            return true;
        }
        return false;
    }

    public boolean isPassword(String password){//判断密码是否大于等于6位
        if (password.length() <= 6){
            return true;
        }
        return false;
    }
    public Boolean isPasswordNull(String password) {//判断密码是否为空
        if (password == null | password == ""){
            return true;
        }
        return false;
    }

    public boolean isUsernameNull(String username) {//判断账号是否为空
        if (username == null | username == ""){
            return true;
        }
        return false;
    }
}
