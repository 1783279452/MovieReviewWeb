package com.example.moviereviewweb.service.impl;

import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.Bean.User;
import com.example.moviereviewweb.mapper.UserMapper;
import com.example.moviereviewweb.service.UserService;
import com.example.moviereviewweb.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result adduser(User user) {//添加用户
/*        if (isUserName(user.getUsername())){
            return Result.error("失败，添加的用户名重复");
        }*/
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
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));//TODO 密码md5加密
        if (user.getStatu().equals("1")){
            if (isUserName(user.getUsername())){
                return Result.error("失败，用户的用户名重复");
            }
            userMapper.adduser(user);
            return Result.success("用户注册成功");
        }else if (user.getStatu().equals("2")){
            if (isAdminName(user.getUsername())){
                return Result.error("失败，管理员的用户名重复");
            }
            userMapper.addadmin(user);
            return Result.success("管理员注册成功");
        }
        return Result.error("失败");
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

    @Override
    public Result login(User user) {//登录
        User user1 = new User();
        if (user.getStatu().equals("1")){
            user1 = userMapper.loginUser(user);
        }else if (user.getStatu().equals("2")){
            user1 = userMapper.loginAdmin(user);
        }

        /*生成jwt令牌，并返回前端（如果调用mapper方法判断账号密码存在 登录成功的话）*/
        if (user1 != null){
            HashMap<String, Object> map1 = new HashMap<>();
//            Map<String, Object> map1 = new HashMap<>();
            map1.put("id",user.getUID());
            map1.put("password",user.getPassword());
            map1.put("username",user.getUsername());
            String jwtNum = JwtUtils.generateJwt(map1);
            /*调用jwt工具类，往里传递map集合，该集合包括要生成的员工的信息,然后借此信息生成jwt令牌*/

/*            if(user.getStatu().equals("1")){
                return Result.success("用户：" + jwtNum);
            }else if (user.getStatu().equals("2")){
                return Result.success("管理员：" + jwtNum);
            }else {
                return Result.success("游客：" + jwtNum);
            }*/

            //return Result.success(user1  + "token: " +jwtNum);

            HashMap<String, Object> result = new HashMap<>();
            result.put("uid", user1.getUID());
            result.put("statu", user1.getStatu());
            result.put("token", jwtNum);

            return Result.success(result);
        }else {
            return Result.error("用户名或密码错误");
        }
    }

    /*以下为异常逻辑处理*/
    public boolean isUid(Integer id){//判断是否存在uid
        if (userMapper.isUid(id) >= 1){
            return true;
        }
        return false;
    }
    public boolean isUserName(String username){//判断是否存在用户账号
        if (userMapper.isUsername(username) >=1 ){
            return true;
        }
        return false;
    }
    public boolean isAdminName(String username){//判断是否存在用户账号
        if (userMapper.isAdminName(username) >=1 ){
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
