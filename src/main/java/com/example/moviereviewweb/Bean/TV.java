package com.example.moviereviewweb.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TV {//电视剧
    private Integer TID;//电视剧id
    private String Name;//名字
    private String imgUrl;//图片
    private String ReleaseTime;//上映年份
    private String type;//类型
    private Float T_score;//评分，默认为0.0
    private String country;//上映国家
    private Short state;//状态，0连载，1完结，默认0
    private String summary;//简介

}
