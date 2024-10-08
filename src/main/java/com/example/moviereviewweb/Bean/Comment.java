package com.example.moviereviewweb.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {//单一评价表

    private Integer EID;//单一评价的id
    private Integer commentUID;//评价所属用户id
    private Integer commentMID;//评价所属电影id，默认0，如非电影评价则为0
    private Integer commentTID;//评价所属电视剧id，默认0，如非电视剧评价则为0
    private String content;//评价内容
    private LocalDateTime time;//评价时间
    private float score;//评价分数
}
