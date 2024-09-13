package com.example.moviereviewweb.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {//用户类
    private Integer UID;//用户id
    private String username;//账号
    private String password;//密码
    private String name;//昵称
    private String avatarUrl;//头像
    private String phoneNumber;//手机号
    private short gender;//性别，默认1男2女
    private String statu;//身份 0游客 1用户 2管理员
    private LocalDateTime createTime; //创建时间

}
