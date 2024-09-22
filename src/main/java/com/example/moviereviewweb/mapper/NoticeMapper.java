package com.example.moviereviewweb.mapper;

import com.example.moviereviewweb.Bean.Notice;

import java.util.List;

public interface NoticeMapper {
    void insert(Notice notice);

    void updateById(Notice notice);

    void deleteById(Integer id);

    List<Notice> selectAll(Notice notice);



}
