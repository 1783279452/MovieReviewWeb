package com.example.moviereviewweb.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {//电影 8项

    private Integer MID;//电影id
    private String Name;//名字
    private String imgUrl;//图片
    private String ReleaseTime;//上映年份
    private String type;//类型
    private Float M_score;//评分，默认为0.0
    private String language;//放映语言
    private LocalDateTime CreatTime;//记录创建时间
    private String summary;//简介

}
