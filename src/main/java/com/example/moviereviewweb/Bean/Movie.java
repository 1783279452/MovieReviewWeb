package com.example.moviereviewweb.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {//电影
    private Integer MID;//电影id
    private String Name;//名字
    private String imgUrl;//图片
    private String ReleaseTime;//上映年份
    private String type;//类型
    private Float M_score;//评分，默认为0.0
    private String country;//上映国家
    private String summary;//简介

}
