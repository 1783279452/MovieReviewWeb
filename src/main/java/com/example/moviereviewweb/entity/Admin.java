package com.example.moviereviewweb.entity;

/**
 * 管理员
*/
public class Admin extends Account {

    /** ID */
    private Integer uid;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 姓名 */
    private String name;
    /** 头像 */
    private String avatarurl;
    /** 角色标识 */
    private String statu;

    @Override
    public Integer getId() {
        return uid;
    }

    @Override
    public void setId(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAvatar() {
        return avatarurl;
    }

    @Override
    public void setAvatar(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    @Override
    public String getStatu() { return statu; }

    @Override
    public void setStatu(String statu) { this.statu = statu; }
}